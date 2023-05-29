package com.renan.bjcarta.controller;

import com.renan.bjcarta.entities.Carta;
import com.renan.bjcarta.services.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping(path ="/carta")
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @GetMapping
    public ResponseEntity<List<Carta>> listaTodasCartas(){

        return ResponseEntity.ok().body(cartaService.listarTodasCartas());

    }

}
