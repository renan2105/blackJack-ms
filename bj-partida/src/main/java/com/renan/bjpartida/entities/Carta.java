package com.renan.bjpartida.entities;

import com.renan.bjpartida.entities.enums.NaipeCartaEnum;

public class Carta {

    private String nome;

    private NaipeCartaEnum naipe;

    private Integer pontos;


    public Carta(String nome, NaipeCartaEnum naipe, Integer pontos) {
        this.nome = nome;
        this.naipe = naipe;
        this.pontos = pontos;
    }

    public Carta() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NaipeCartaEnum getNaipe() {
        return naipe;
    }

    public void setNaipe(NaipeCartaEnum naipe) {
        this.naipe = naipe;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }
}
