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

        return partidaRepository.findById(id).get();

    }

    public PartidaDTO puxaCarta(Long partidaId, Long jogadorId, Boolean parou){

        Partida partida = buscaPartida(partidaId);
        PartidaDTO partidaDTO = partidaToDTO(partida);

//        fazer um tratamento de exceção aqui para caso tenham digitado id inexistente
        Jogador jogadorAtual = partida.getJogadores().stream().filter(jogador -> jogador.getId().equals(jogadorId)).findFirst().get();

        if(partida.getStatus().equals(StatusPartidaEnum.FINALIZADO)){
            //criar retorno de partida finalizada e retorno com vitorioso
            partidaDTO.setMensagem("Jogador " + partida.getVencedor().getNome() + " eh o vencedor parabeins!");
            return partidaDTO;
        }

        if(jogadorAtual.getStatus().equals(StatusJogadorEnum.ULTRAPASSOU)){
            //criar retorno de partida que jogador ultrapassou o limite de carta
            partidaDTO.setMensagem("Jogador " + jogadorAtual.getNome() + " ja ultrapassou os 21 pontos.");
            return partidaDTO;
        }

        if(jogadorAtual.getStatus().equals(StatusJogadorEnum.PAROU)){
            //criar retorno de partida que jogador parou de jogar
            partidaDTO.setMensagem("Jogador " + jogadorAtual.getNome() + " ja parou de puxar.");
            return partidaDTO;
        }

        if(jogadorAtual.getRodada().equals(partida.getRodada())){
            //criar retorno de partida que jogador ja jogou nesta rodada
            partidaDTO.setMensagem("Jogador " + jogadorAtual.getNome() + " ja puxou esta rodada.");
            return partidaDTO;
        }

        if(parou){
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

        boolean todosJogaram = true;

        boolean NaoAJogadoresJogando = true;

        for(Jogador jogador : partida.getJogadores()){

            if(!jogador.getRodada().equals(partida.getRodada()))
                todosJogaram = false;

            if(jogador.getStatus().equals(StatusJogadorEnum.JOGANDO))
                NaoAJogadoresJogando = false;
        }

        if(todosJogaram)
            partida.setRodada(partida.getRodada() + 1);

        if(NaoAJogadoresJogando)
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

        switch (partida.getStatus()){
            case EMPATE:
                partidaDTO.setMensagem("Empate");
                break;
            case DERROTA:
                partidaDTO.setMensagem("Ninguem venceu.");
                break;
            case FINALIZADO:
                partidaDTO.setMensagem("Jogador " + partidaDTO.getVencedor().getNome() + " eh o vencedor parabeins!");
                break;
            default:
                if(jogadorAtual.getStatus().equals(StatusJogadorEnum.PAROU))
                    partidaDTO.setMensagem("Jogador " + jogadorAtual.getNome() + " parou de puxar com a ponutacao de " + jogadorAtual.getPontuacao());
                else
                    partidaDTO.setMensagem("Jogador " + jogadorAtual.getNome() + " puxou e esta com " + jogadorAtual.getPontuacao() + " pontos.");
        }

        return partidaDTO;

    }

    public PartidaDTO partidaToDTO(Partida partida){

        return new PartidaDTO(partida.getId(), partida.getRodada(), partida.getJogadores(),
                partida.getStatus(), partida.getVencedor(), null);

    }

}
