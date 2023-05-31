package com.renan.bjcarta.services;

import com.renan.bjcarta.dto.PartidaDTO;
import com.renan.bjcarta.entities.Partida;

public interface PartidaService {

    Partida iniciaPartida(String nomePrimeiroJogador, String nomeSegundoJogador, String nomeTerceiroJogador,
                          String nomeQuartoJogador);

    Partida buscaPartida(Long id);

    PartidaDTO puxaCarta(Long partidaId, Long jogadorId, Boolean parou);

}
