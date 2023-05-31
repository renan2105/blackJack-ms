package com.renan.bjcarta.services.serviceImpl;

import com.renan.bjcarta.dto.PartidaDTO;
import com.renan.bjcarta.entities.Partida;
import com.renan.bjcarta.entities.enums.StatusPartidaEnum;
import com.renan.bjcarta.repositories.CartaRepository;
import com.renan.bjcarta.repositories.PartidaRepository;
import com.renan.bjcarta.services.CartaService;
import com.renan.bjcarta.services.JogadorService;
import com.renan.bjcarta.services.exceptions.ResourceNotFoundException;
import com.renan.bjcarta.services.exceptions.ValidateException;
import com.renan.bjcarta.utils.GeradorPartidaUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PartidaServiceImplTest {

    @InjectMocks
    private PartidaServiceImpl partidaService;

    @Mock
    private PartidaRepository partidaRepositoryMock;

    @Mock
    private CartaService cartaServiceMock;

    @Mock
    private JogadorService jogadorServiceMock;
    
    
    @BeforeEach
    void setUp() {

        Partida partida = GeradorPartidaUtils.geraPartida();
        BDDMockito.when(partidaRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(partida));
        BDDMockito.when(partidaRepositoryMock.save(ArgumentMatchers.any())).thenReturn(partida);

    }


    @Test
    void iniciaPartida_sucesso() {

        Partida partidaEsperada = GeradorPartidaUtils.geraPartida();

        Partida partida = partidaService.iniciaPartida("player",
                "player2","player3","player4");

        Assertions.assertThat(partida).isNotNull();
        Assertions.assertThat(partida.getId()).isEqualTo(partidaEsperada.getId());

    }

    @Test
    void buscaPartida_sucesso() {

        Partida partida = GeradorPartidaUtils.geraPartida();
        Partida partidaDB = partidaService.buscaPartida(1L);

        Assertions.assertThat(partidaDB).isNotNull();
        Assertions.assertThat(partida).isEqualToComparingFieldByField(partidaDB);

    }

    @Test
    void buscaPartida_Throws_ResourceNotFoundException() {

        BDDMockito.when(partidaRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(ResourceNotFoundException.class).isThrownBy(() -> partidaService.buscaPartida(1L));

    }

    @Test
    void puxaCarta_Sucesso() {

        Partida partidaComum = GeradorPartidaUtils.geraPartidaRodadaSucesso();
        BDDMockito.when(partidaRepositoryMock.findById(1L)).thenReturn(Optional.of(partidaComum));

        PartidaDTO partidaDTO = partidaService.puxaCarta(1L, 1L, false);

        Assertions.assertThat(partidaDTO).isNotNull();
        Assertions.assertThat(partidaDTO.getStatus()).isEqualTo(StatusPartidaEnum.PROGRESSO);

    }

    @Test
    void puxaCarta_jogadorParouDePuxa_Sucesso() {

        Partida partidaComum = GeradorPartidaUtils.geraPartidaRodadaSucesso();
        BDDMockito.when(partidaRepositoryMock.findById(2L)).thenReturn(Optional.of(partidaComum));

        PartidaDTO partidaDTO = partidaService.puxaCarta(2L, 1L, true);

        Assertions.assertThat(partidaDTO).isNotNull();
        Assertions.assertThat(partidaDTO.getStatus()).isEqualTo(StatusPartidaEnum.PROGRESSO);

    }

    @Test
    void puxaCarta_Finalizada_Sucesso() {

        Partida partidaFinalizada = GeradorPartidaUtils.geraPartidaFinalizada();
        BDDMockito.when(partidaRepositoryMock.findById(3L)).thenReturn(Optional.of(partidaFinalizada));

        PartidaDTO partidaDTO = partidaService.puxaCarta(3L, 1L, true);

        Assertions.assertThat(partidaDTO).isNotNull();
        Assertions.assertThat(partidaDTO.getStatus()).isEqualTo(StatusPartidaEnum.FINALIZADO);
        Assertions.assertThat(partidaDTO.getVencedor()).isNotNull();

    }

    @Test
    void puxaCarta_Empate_Sucesso() {

        Partida partidaEmpatada = GeradorPartidaUtils.geraPartidaEmpatada();
        BDDMockito.when(partidaRepositoryMock.findById(4L)).thenReturn(Optional.of(partidaEmpatada));

        PartidaDTO partidaDTO = partidaService.puxaCarta(4L, 1L, true);

        Assertions.assertThat(partidaDTO).isNotNull();
        Assertions.assertThat(partidaDTO.getStatus()).isEqualTo(StatusPartidaEnum.EMPATE);

    }

    @Test
    void puxaCarta_Derrota_Sucesso() {

        Partida partidaDerrota = GeradorPartidaUtils.geraPartidaDerrota();
        BDDMockito.when(partidaRepositoryMock.findById(5L)).thenReturn(Optional.of(partidaDerrota));

        PartidaDTO partidaDTO = partidaService.puxaCarta(5L, 1L, true);

        Assertions.assertThat(partidaDTO).isNotNull();
        Assertions.assertThat(partidaDTO.getStatus()).isEqualTo(StatusPartidaEnum.DERROTA);

    }

    @Test
    void puxaCarta_ValidateException_Ultrapassou() {

        Partida partida = GeradorPartidaUtils.geraPartidaJogadorUltrapassou();
        BDDMockito.when(partidaRepositoryMock.findById(6L)).thenReturn(Optional.of(partida));

        Assertions.assertThatExceptionOfType(ValidateException.class).isThrownBy(() -> partidaService.puxaCarta(6L, 22L, false));

    }

    @Test
    void puxaCarta_ValidateException_Parou() {

        Partida partida = GeradorPartidaUtils.geraPartidaJogadorParou();
        BDDMockito.when(partidaRepositoryMock.findById(7L)).thenReturn(Optional.of(partida));

        Assertions.assertThatExceptionOfType(ValidateException.class).isThrownBy(() -> partidaService.puxaCarta(7L, 20L, false));

    }

    @Test
    void puxaCarta_ValidateException_JaJogou() {

        Partida partida = GeradorPartidaUtils.geraPartidaJogadorJaJogou();
        BDDMockito.when(partidaRepositoryMock.findById(1L)).thenReturn(Optional.of(partida));

        Assertions.assertThatExceptionOfType(ValidateException.class).isThrownBy(() -> partidaService.puxaCarta(1L, 1L, false));

    }
}