package com.renan.bjcarta.utils;

import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.entities.enums.StatusJogadorEnum;

import java.util.HashSet;
import java.util.Set;

public class GeradorJogadorUtils {

    public static Jogador geraJogador(){
        return new Jogador(null, "player", 0, 1, new HashSet<>(), StatusJogadorEnum.JOGANDO);
    }

    public static Set<Jogador> geraSetJogadoresComum(){

        Set<Jogador> jogadores = new HashSet<>();
        jogadores.add(new Jogador(1L, "player", 1, 2, new HashSet<>(), StatusJogadorEnum.JOGANDO));
        return jogadores;
    }

    public static Set<Jogador> geraSetJogadorUltrapassou(){

        Set<Jogador> jogadores = new HashSet<>();
        jogadores.add(new Jogador(22L, "ultrapassei", 22, 5, new HashSet<>(), StatusJogadorEnum.ULTRAPASSOU));
        return jogadores;
    }

    public static Set<Jogador> geraSetJogadorParou(){

        Set<Jogador> jogadores = new HashSet<>();
        jogadores.add(new Jogador(20L, "parei", 20, 3, new HashSet<>(), StatusJogadorEnum.PAROU));
        return jogadores;
    }


}
