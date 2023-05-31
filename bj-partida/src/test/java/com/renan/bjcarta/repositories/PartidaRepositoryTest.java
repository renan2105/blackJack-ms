package com.renan.bjcarta.repositories;

import com.renan.bjcarta.entities.Partida;
import com.renan.bjcarta.utils.GeradorPartidaUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PartidaRepositoryTest {

    @Autowired
    private PartidaRepository partidaRepository;

    @Test
    public void save_Sucesso(){

        Partida partida = GeradorPartidaUtils.geraPartida();
        Partida partidaDb = this.partidaRepository.save(partida);

        Assertions.assertThat(partidaDb).isNotNull();
        Assertions.assertThat(partidaDb.getId()).isNotNull();
        Assertions.assertThat(partidaDb.getRodada()).isEqualTo(partida.getRodada());
    }

    @Test
    public void findById_Sucesso(){

        Partida partida = GeradorPartidaUtils.geraPartida();
        Partida partidaDb = this.partidaRepository.save(partida);

        Long partidaId = partidaDb.getId();
        Optional<Partida> partidaFound = partidaRepository.findById(partidaId);

        Assertions.assertThat(partidaFound).isNotNull();

    }
}