package com.renan.bjcarta.entities;

import com.renan.bjcarta.entities.enums.StatusJogadorEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "tb_jogador")
public class Jogador implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer pontuacao;

    private Integer rodada;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_jogador_carta",
            joinColumns = @JoinColumn(name = "jogador_id"),
            inverseJoinColumns = @JoinColumn(name = "carta_id")
    )
    Set<Carta> cartas = new HashSet<>();

    private StatusJogadorEnum status;


    public Jogador() {
    }

    public Jogador(Long id, String nome, Integer pontuacao, Integer rodada, Set<Carta> cartas, StatusJogadorEnum status) {
        this.id = id;
        this.nome = nome;
        this.pontuacao = pontuacao;
        this.rodada = rodada;
        this.cartas = cartas;
        this.status = status;
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

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Integer getRodada() {
        return rodada;
    }

    public void setRodada(Integer rodada) {
        this.rodada = rodada;
    }

    public Set<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Set<Carta> cartas) {
        this.cartas = cartas;
    }

    public StatusJogadorEnum getStatus() {
        return status;
    }

    public void setStatus(StatusJogadorEnum status) {
        this.status = status;
    }
}
