package com.renan.bjcarta.services;

import com.renan.bjcarta.entities.Partida;

public interface PartidaService {

    Partida iniciaPartida(String nomePrimeiroJogador, String nomeSegundoJogador, String nomeTerceiroJogador,
                          String nomeQuartoJogador);

}
