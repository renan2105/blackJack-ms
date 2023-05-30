package com.renan.bjcarta.entities;

import com.renan.bjcarta.entities.enums.StatusPartidaEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "tb_partida")
public class Partida implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rodada;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_partida_jogador",
            joinColumns = @JoinColumn(name = "partida_id"),
            inverseJoinColumns = @JoinColumn(name = "jogador_id")
    )
    Set<Jogador> jogadores = new HashSet<>();
    
    private StatusPartidaEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogador_id")
    private Jogador vencedor;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_partida_carta",
            joinColumns = @JoinColumn(name = "partida_id"),
            inverseJoinColumns = @JoinColumn(name = "carta_id")
    )
    Set<Carta> baralho = new HashSet<>();


    public Partida() {
    }

    public Partida(Long id, Integer rodada, Set<Jogador> jogadores, StatusPartidaEnum status, Jogador vencedor, Set<Carta> baralho) {
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

    public Set<Carta> getBaralho() {
        return baralho;
    }

    public void setBaralho(Set<Carta> baralho) {
        this.baralho = baralho;
    }
}
