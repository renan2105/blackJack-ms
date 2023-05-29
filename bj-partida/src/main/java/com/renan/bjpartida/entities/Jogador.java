package com.renan.bjpartida.entities;

import com.renan.bjpartida.entities.enums.StatusJogadorEnum;

import java.util.List;

public class Jogador {

    private String nome;

    private Integer pontuacao;

    private List<Carta> cartas;

    private StatusJogadorEnum status;


    public Jogador() {
    }

    public Jogador( String nome, Integer pontuacao, List<Carta> cartas, StatusJogadorEnum status) {
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.cartas = cartas;
        this.status = status;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public StatusJogadorEnum getStatus() {
        return status;
    }

    public void setStatus(StatusJogadorEnum status) {
        this.status = status;
    }
}
