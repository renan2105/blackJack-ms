package com.renan.bjcarta.dto;

import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.entities.enums.StatusPartidaEnum;

import java.util.HashSet;
import java.util.Set;

public class PartidaDTO {

    private Long id;

    private Integer rodada;

    Set<Jogador> jogadores = new HashSet<>();

    private StatusPartidaEnum status;

    private Jogador vencedor;

    private String mensagem;


    public PartidaDTO() {
    }

    public PartidaDTO(Long id, Integer rodada, Set<Jogador> jogadores, StatusPartidaEnum status, Jogador vencedor, String mensagem) {
        this.id = id;
        this.rodada = rodada;
        this.jogadores = jogadores;
        this.status = status;
        this.vencedor = vencedor;
        this.mensagem = mensagem;
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

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Set<Jogador> jogadores) {
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
