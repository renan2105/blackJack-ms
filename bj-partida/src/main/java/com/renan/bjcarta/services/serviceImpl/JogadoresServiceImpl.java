package com.renan.bjcarta.services.serviceImpl;

import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.entities.enums.StatusJogadorEnum;
import com.renan.bjcarta.repositories.JogadorRepository;
import com.renan.bjcarta.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JogadoresServiceImpl implements JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;


    public Set<Jogador> criaJogadores(List<String> nomeJogadores) {


        Set<Jogador> jogadores = new HashSet<>();

        for(String nomeJogador : nomeJogadores){

            if(nomeJogador != null){
                Jogador jogador = new Jogador(null,
                        nomeJogador,
                        0,
                        new HashSet<>(),
                        StatusJogadorEnum.JOGANDO);

                jogadores.add(saveJogador(jogador));
            }


        }

        return jogadores;
    }

    public Jogador saveJogador(Jogador jogador){

        return jogadorRepository.save(jogador);

    }

}
