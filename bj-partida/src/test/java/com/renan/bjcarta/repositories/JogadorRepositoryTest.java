package com.renan.bjcarta.repositories;

import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.utils.GeradorJogadorUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JogadorRepositoryTest {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Test
    public void save_Sucesso(){

        Jogador jogador = GeradorJogadorUtils.geraJogador();
        Jogador jogadorDb = this.jogadorRepository.save(jogador);

        Assertions.assertThat(jogadorDb).isNotNull();
        Assertions.assertThat(jogadorDb.getId()).isNotNull();
        Assertions.assertThat(jogadorDb.getNome()).isEqualTo(jogador.getNome());
    }

}