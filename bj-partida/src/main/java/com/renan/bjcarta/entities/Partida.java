package com.renan.bjcarta.entities;

import com.renan.bjcarta.entities.enums.StatusPartidaEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class Partida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rodada;

    private List<Jogador> jogadores;

    private StatusPartidaEnum status;

    private Jogador vencedor;

    private List<Carta> baralho;


    public Partida() {
    }

    public Partida(Long id, Integer rodada, List<Jogador> jogadores, StatusPartidaEnum status, Jogador vencedor, List<Carta> baralho) {
        this.id = id;
        this.rodada = rodada;
        this.jogadores = jogadores;
        this.status = status;
        this.vencedor = vencedor;
        this.baralho = baralho;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public StatusPartidaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPartidaEnum status) {
        this.status = status;
    }

    public Jogador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public List<Carta> getBaralho() {
        return baralho;
    }

    public void setBaralho(List<Carta> baralho) {
        this.baralho = baralho;
    }
}
