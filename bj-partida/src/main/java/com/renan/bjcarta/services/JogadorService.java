package com.renan.bjcarta.services;

import com.renan.bjcarta.entities.Jogador;

import java.util.List;
import java.util.Set;

public interface JogadorService {

    Set<Jogador> criaJogadores(List<String> nomeJogadores);

}
