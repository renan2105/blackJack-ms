package com.renan.bjcarta.utils;

import com.renan.bjcarta.dto.PartidaDTO;
import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.entities.Partida;
import com.renan.bjcarta.entities.enums.NaipeCartaEnum;
import com.renan.bjcarta.entities.enums.StatusJogadorEnum;
import com.renan.bjcarta.entities.enums.StatusPartidaEnum;

import java.util.HashSet;

public class GeradorPartidaUtils {

    public static PartidaDTO geraPartidaDTO(){
        return new PartidaDTO(1L,3,new HashSet<>(), StatusPartidaEnum.FINALIZADO, null, null);
    }

    public static Partida geraPartida(){
        return new Partida(1L, 1, new HashSet<>(), StatusPartidaEnum.PROGRESSO,null,new HashSet<>());
    }

    public static Partida geraPartidaRodadaSucesso(){
        return new Partida(1L, 1, GeradorJogadorUtils.geraSetJogadoresComum(), StatusPartidaEnum.PROGRESSO,
                null ,GeradorCartaUtils.geraSetCarta());
    }

    public static Partida geraPartidaFinalizada(){
        return new Partida(3L, 1, new HashSet<>(), StatusPartidaEnum.FINALIZADO,new Jogador(1L, "vencedor",
                21,4,new HashSet<>(), StatusJogadorEnum.JOGANDO),new HashSet<>());
    }

    public static Partida geraPartidaEmpatada(){
        return new Partida(4L, 1, new HashSet<>(), StatusPartidaEnum.EMPATE,null,new HashSet<>());
    }

    public static Partida geraPartidaDerrota(){
        return new Partida(5L, 1, new HashSet<>(), StatusPartidaEnum.DERROTA,null,new HashSet<>());
    }

    public static Partida geraPartidaJogadorUltrapassou(){
        return new Partida(6L, 1, GeradorJogadorUtils.geraSetJogadorUltrapassou(), StatusPartidaEnum.PROGRESSO,null,new HashSet<>());
    }

    public static Partida geraPartidaJogadorParou(){
        return new Partida(7L, 1, GeradorJogadorUtils.geraSetJogadorParou(), StatusPartidaEnum.PROGRESSO,null,new HashSet<>());
    }

    public static Partida geraPartidaJogadorJaJogou(){
        return new Partida(8L, 2, GeradorJogadorUtils.geraSetJogadoresComum(), StatusPartidaEnum.PROGRESSO,null,new HashSet<>());
    }
}
