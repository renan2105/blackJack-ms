package com.renan.bjcarta.controller;

import com.renan.bjcarta.dto.PartidaDTO;
import com.renan.bjcarta.entities.Partida;
import com.renan.bjcarta.services.PartidaService;
import com.renan.bjcarta.utils.GeradorPartidaUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class PartidaControllerTest {

    @InjectMocks
    private PartidaController partidaController;

    @Mock
    private PartidaService partidaServiceMock;


    @BeforeEach
    void setUp() {
        PartidaDTO puxaCartaPartidaDTO = GeradorPartidaUtils.geraPartidaDTO();
        BDDMockito.when(partidaServiceMock.puxaCarta(ArgumentMatchers.anyLong(),ArgumentMatchers.anyLong(),
                        ArgumentMatchers.anyBoolean())).thenReturn(puxaCartaPartidaDTO);

        Partida partida = GeradorPartidaUtils.geraPartida();
        BDDMockito.when(partidaServiceMock.iniciaPartida(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(),ArgumentMatchers.anyString())).thenReturn(partida);

        BDDMockito.when(partidaServiceMock.buscaPartida(ArgumentMatchers.anyLong())).thenReturn(partida);

    }

    @Test
    void iniciaPartida_Sucesso() {

        Partida partidaEsperada = GeradorPartidaUtils.geraPartida();

        Partida partida = partidaController.buscaPartida(1L).getBody();

        Assertions.assertThat(partida).isNotNull();
        Assertions.assertThat(partida.getId()).isEqualTo(partidaEsperada.getId());

    }

    @Test
    void buscaPartida_Sucesso() {

        Partida partidaEsperada = GeradorPartidaUtils.geraPartida();

        Partida partida = partidaController.buscaPartida(1L).getBody();

        Assertions.assertThat(partida).isNotNull();
        Assertions.assertThat(partida.getId()).isEqualTo(partidaEsperada.getId());

    }

    @Test
    void puxaCarta_Sucesso() {

        PartidaDTO partidaDTOEsperada = GeradorPartidaUtils.geraPartidaDTO();

        PartidaDTO partidaDTO = partidaController.puxaCarta(1L, 1L, true).getBody();

        Assertions.assertThat(partidaDTO).isNotNull();
        Assertions.assertThat(partidaDTO.getId()).isEqualTo(partidaDTOEsperada.getId());

    }
}