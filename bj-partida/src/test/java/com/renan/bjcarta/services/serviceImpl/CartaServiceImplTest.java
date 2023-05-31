package com.renan.bjcarta.services.serviceImpl;

import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.repositories.CartaRepository;
import com.renan.bjcarta.utils.GeradorCartaUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CartaServiceImplTest {

    @InjectMocks
    private CartaServiceImpl cartaService;

    @Mock
    private CartaRepository cartaRepositoryMock;


    @BeforeEach
    void setUp() {

        List<Carta> cartas = GeradorCartaUtils.geraListaCarta();
        BDDMockito.when(cartaRepositoryMock.findAll()).thenReturn(cartas);


    }

    @Test
    void listarTodasCartas_sucesso() {

        Set<Carta> consultaTodosResponse = cartaService.listarTodasCartas();

        Assertions.assertThat(consultaTodosResponse).isNotEmpty();

    }
}