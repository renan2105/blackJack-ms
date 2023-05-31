package com.renan.bjcarta.services.serviceImpl;

import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.repositories.JogadorRepository;
import com.renan.bjcarta.utils.GeradorJogadorUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class JogadoresServiceImplTest {

    @InjectMocks
    private JogadoresServiceImpl jogadoresService;

    @Mock
    private JogadorRepository jogadorRepositoryMock;


    @BeforeEach
    void setUp() {

        Jogador jogador = GeradorJogadorUtils.geraJogador();
        BDDMockito.when(jogadorRepositoryMock.save(ArgumentMatchers.any(Jogador.class))).thenReturn(jogador);

    }

    @Test
    void criaJogadores_sucesso() {

        Set<Jogador> jogadoresDB = jogadoresService.criaJogadores(List.of("player"));

        Assertions.assertThat(jogadoresDB).isNotEmpty();

    }
}