package com.renan.bjcarta.services.serviceImpl;

import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.repositories.CartaRepository;
import com.renan.bjcarta.services.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CartaServiceImpl implements CartaService {

    @Autowired
    private CartaRepository cartaRepository;


    public Set<Carta> listarTodasCartas(){

        return new HashSet<Carta>(cartaRepository.findAll());

    }

}
