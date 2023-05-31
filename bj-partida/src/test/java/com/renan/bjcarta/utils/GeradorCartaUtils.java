package com.renan.bjcarta.utils;

import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.entities.enums.NaipeCartaEnum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeradorCartaUtils {

    public static List<Carta> geraListaCarta(){

        return Arrays.asList(new Carta(1L, "A", NaipeCartaEnum.ESPADAS, 1),
                new Carta(2L, "2", NaipeCartaEnum.PAUS, 2),
                new Carta(3L, "3", NaipeCartaEnum.COPAS, 3),
                new Carta(4L, "4", NaipeCartaEnum.OUROS, 4));
    }

    public static Set<Carta> geraSetCarta(){

        Set<Carta> cartas = new HashSet<>();

        cartas.add(new Carta(1L, "A", NaipeCartaEnum.ESPADAS, 1));
        cartas.add(new Carta(2L, "2", NaipeCartaEnum.PAUS, 2));
        cartas.add(new Carta(3L, "3", NaipeCartaEnum.COPAS, 3));
        cartas.add(new Carta(4L, "4", NaipeCartaEnum.OUROS, 4));

        return cartas;
    }

}
