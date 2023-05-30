package com.renan.bjcarta.services.serviceImpl;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.renan.bjcarta.entities.Partida;
import com.renan.bjcarta.entities.enums.StatusPartidaEnum;
import com.renan.bjcarta.repositories.PartidaRepository;
import com.renan.bjcarta.services.CartaService;
import com.renan.bjcarta.services.JogadorService;
import com.renan.bjcarta.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

        return partidaRepository.save(partida);

    }


}
