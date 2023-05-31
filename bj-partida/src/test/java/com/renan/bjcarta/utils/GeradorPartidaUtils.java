package com.renan.bjcarta.utils;

import com.renan.bjcarta.dto.PartidaDTO;
import com.renan.bjcarta.entities.Partida;
import com.renan.bjcarta.entities.enums.StatusPartidaEnum;

import java.util.HashSet;

public class GeradorPartidaUtils {

    public static PartidaDTO geraPartidaDTO(){
        return new PartidaDTO(1L,3,new HashSet<>(), StatusPartidaEnum.FINALIZADO, null, null);
    }

    public static Partida geraPartida(){
        return new Partida(1L, 1, new HashSet<>(), StatusPartidaEnum.PROGRESSO,null,new HashSet<>());
    }
}
