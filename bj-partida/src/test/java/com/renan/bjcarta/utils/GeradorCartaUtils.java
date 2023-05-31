package com.renan.bjcarta.utils;

import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.entities.enums.NaipeCartaEnum;

import java.util.Arrays;
import java.util.List;

public class GeradorCartaUtils {

    public static List<Carta> geraListaCarta(){

        return Arrays.asList(new Carta(1L, "A", NaipeCartaEnum.ESPADAS, 1),
                new Carta(2L, "2", NaipeCartaEnum.PAUS, 2),
                new Carta(3L, "3", NaipeCartaEnum.COPAS, 3),
                new Carta(4L, "4", NaipeCartaEnum.OUROS, 4));
    }

}
