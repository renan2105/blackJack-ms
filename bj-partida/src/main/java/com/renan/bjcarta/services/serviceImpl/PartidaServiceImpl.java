package com.renan.bjcarta.services.serviceImpl;

import com.renan.bjcarta.dto.PartidaDTO;
import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.entities.Partida;
import com.renan.bjcarta.entities.enums.StatusJogadorEnum;
import com.renan.bjcarta.entities.enums.StatusPartidaEnum;
import com.renan.bjcarta.repositories.PartidaRepository;
import com.renan.bjcarta.services.CartaService;
import com.renan.bjcarta.services.JogadorService;
import com.renan.bjcarta.services.PartidaService;
import com.renan.bjcarta.services.exceptions.ResourceNotFoundException;
import com.renan.bjcarta.services.exceptions.ValidateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class PartidaServiceImpl implements PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private CartaService cartaService;

    @Autowired
    private JogadorService jogadorService;



    public Partida iniciaPartida(String nomePrimeiroJogador, String nomeSegundoJogador, String nomeTerceiroJogador,
                                 String nomeQuartoJogador){

        List<String> nomeJogadores = Arrays.asList(nomePrimeiroJogador, nomeSegundoJogador, nomeTerceiroJogador, nomeQuartoJogador);


        Partida partida = new Partida(null,
                1,
                jogadorService.criaJogadores(nomeJogadores),
                StatusPartidaEnum.PROGRESSO,
                null,
                cartaService.listarTodasCartas()
                );

        return savePartida(partida);

    }

    private Partida savePartida(Partida partida){

        return partidaRepository.save(partida);

    }

    public Partida buscaPartida(Long id){

        return partidaRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Partida com id : " + id));

    }

    public PartidaDTO puxaCarta(Long partidaId, Long jogadorId, Boolean parou){

        Partida partida = buscaPartida(partidaId);
        PartidaDTO partidaDTO = partidaToDTO(partida);

        if(partida.getStatus().equals(StatusPartidaEnum.FINALIZADO)
                || partida.getStatus().equals(StatusPartidaEnum.EMPATE)
                || partida.getStatus().equals(StatusPartidaEnum.DERROTA)){

            partidaDTO.setMensagem(escolheMensagem(partida, partida.getVencedor()));
            return partidaDTO;
        }

        Jogador jogadorAtual = partida.getJogadores().stream().filter(jogador -> jogador.getId().equals(jogadorId))
                .findFirst()
                .orElseThrow(() ->new ResourceNotFoundException("Jogador com id : " + jogadorId));

        validaJogada(partida, jogadorAtual);

        if(parou != null && parou){
            jogadorAtual.setStatus(StatusJogadorEnum.PAROU);
        } else {

            Carta carta = partida.getBaralho().stream().findFirst().get();

            partida.getBaralho().remove(carta);

            jogadorAtual.getCartas().add(carta);

            jogadorAtual.setPontuacao(jogadorAtual.getPontuacao() + carta.getPontos());
            jogadorAtual.setRodada(partida.getRodada());

            if(jogadorAtual.getPontuacao() > 21)
                jogadorAtual.setStatus(StatusJogadorEnum.ULTRAPASSOU);

            if(jogadorAtual.getPontuacao().equals(21)){
                partida.setStatus(StatusPartidaEnum.FINALIZADO);
                partida.setVencedor(jogadorAtual);
            }

        }

        boolean passaRodada = true;

        boolean finalizaPartida = true;

        for(Jogador jogador : partida.getJogadores()){

            if(!jogador.getRodada().equals(partida.getRodada()))
                passaRodada = false;

            if(jogador.getStatus().equals(StatusJogadorEnum.JOGANDO))
                finalizaPartida = false;
        }

        if(passaRodada)
            partida.setRodada(partida.getRodada() + 1);

        if(finalizaPartida)
            partida.setStatus(StatusPartidaEnum.FINALIZADO);

        if(partida.getStatus().equals(StatusPartidaEnum.FINALIZADO) && partida.getVencedor() == null){

            List<Jogador> jogadoresRestantes = new ArrayList<>();
            partida.getJogadores().forEach(
                    jogador -> {
                        if (jogador.getStatus().equals(StatusJogadorEnum.PAROU)){
                            jogadoresRestantes.add(jogador);
                        }
                    }
            );

            if(jogadoresRestantes.isEmpty()){
                partida.setStatus(StatusPartidaEnum.DERROTA);

            } else if(jogadoresRestantes.size() == 1){
                partida.setVencedor(jogadoresRestantes.get(0));

            } else {
                AtomicBoolean empate = new AtomicBoolean(false);

                for(Jogador jogador: jogadoresRestantes){
                    if(partida.getVencedor() == null){
                        partida.setVencedor(jogador);
                    } else if(jogador.getPontuacao()> partida.getVencedor().getPontuacao()){
                        partida.setVencedor(jogador);
                    }
                }

                Partida finalPartida = partida;
                jogadoresRestantes.forEach(
                        jogador -> {
                            if (Objects.equals(jogador.getPontuacao(), finalPartida.getVencedor().getPontuacao())
                                    && !jogador.getNome().equals(finalPartida.getVencedor().getNome()) ){
                                empate.set(true);
                            }
                        }
                );

                if(empate.get())
                    partida.setStatus(StatusPartidaEnum.EMPATE);

            }
        }

        partida = savePartida(partida);
        partidaDTO = partidaToDTO(partida);

        partidaDTO.setMensagem(escolheMensagem(partida, jogadorAtual));

        return partidaDTO;

    }

    private PartidaDTO partidaToDTO(Partida partida){

        return new PartidaDTO(partida.getId(), partida.getRodada(), partida.getJogadores(),
                partida.getStatus(), partida.getVencedor(), null);

    }

    private void validaJogada(Partida partida, Jogador jogador){

        if(jogador.getStatus().equals(StatusJogadorEnum.ULTRAPASSOU)){
            throw new ValidateException("Jogador " + jogador.getNome() + " ja ultrapassou os 21 pontos.");
        }

        if(jogador.getStatus().equals(StatusJogadorEnum.PAROU)){
            throw new ValidateException("Jogador " + jogador.getNome() + " ja parou de puxar.");
        }

        if(jogador.getRodada().equals(partida.getRodada())){
            throw new ValidateException("Jogador " + jogador.getNome() + " ja puxou esta rodada.");
        }
    }
    
    private String escolheMensagem(Partida partida, Jogador jogador){
        
        String mensagem;
        
        switch (partida.getStatus()){
            case EMPATE:
                mensagem = "Empate";
                break;
            case DERROTA:
                mensagem = "Ninguem venceu.";
                break;
            case FINALIZADO:
                mensagem = "Jogador " + partida.getVencedor().getNome() + " eh o vencedor parabeins!";
                break;
            default:
                if(jogador.getStatus().equals(StatusJogadorEnum.PAROU))
                    mensagem = "Jogador " + jogador.getNome() + " parou de puxar com a ponutacao de " + jogador.getPontuacao();
                else
                    mensagem = "Jogador " + jogador.getNome() + " puxou e esta com " + jogador.getPontuacao() + " pontos.";
        }

        return mensagem;
    }
}
