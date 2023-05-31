package com.renan.bjcarta.utils;

import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.entities.enums.StatusJogadorEnum;

import java.util.HashSet;

public class GeradorJogadorUtils {

    public static Jogador geraJogador(){
        return new Jogador(null, "player", 0, 1, new HashSet<>(), StatusJogadorEnum.JOGANDO);
    }
}
