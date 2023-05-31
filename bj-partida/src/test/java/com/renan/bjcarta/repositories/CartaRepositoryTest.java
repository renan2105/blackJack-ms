package com.renan.bjcarta.repositories;

import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.utils.GeradorCartaUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class CartaRepositoryTest {

    @Autowired
    private CartaRepository cartaRepository;


    @Test
    public void findAll_Sucesso(){

        this.cartaRepository.saveAll(GeradorCartaUtils.geraListaCarta());
        List<Carta> cartasDb = cartaRepository.findAll();

        Assertions.assertThat(cartasDb).isNotEmpty();
    }

}