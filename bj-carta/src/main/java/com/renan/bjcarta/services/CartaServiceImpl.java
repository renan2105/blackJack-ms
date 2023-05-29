package com.renan.bjcarta.services;

import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.repositories.CartaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaServiceImpl implements CartaService{

    @Autowired
    private CartaRepository cartaRepository;


    public List<Carta> listarTodasCartas(){

        return cartaRepository.findAll();

    }

}
