package com.renan.bjcarta.entities;

import com.renan.bjcarta.entities.enums.NaipeCartaEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private NaipeCartaEnum naipe;

    private Integer pontos;


    public Carta(Long id, String nome, NaipeCartaEnum naipe, Integer pontos) {
        this.id = id;
        this.nome = nome;
        this.naipe = naipe;
        this.pontos = pontos;
    }

    public Carta() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
