package com.renan.bjcarta.controller;

import com.renan.bjcarta.entities.Partida;
import com.renan.bjcarta.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PathParam;

@RestController
@RequestMapping(value = "/partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;


    @RequestMapping(value = "/iniciaPartida", method = RequestMethod.GET)
    public ResponseEntity<Partida> iniciaPartida(@RequestParam(value = "nomePrimeiroJogador") String nomePrimeiroJogador,
                                                 @RequestParam(required = false, value = "nomeSegundoJogador") String nomeSegundoJogador,
                                                 @RequestParam(required = false, value = "nomeTerceiroJogador") String nomeTerceiroJogador,
                                                 @RequestParam(required = false, value = "nomeQuartoJogador") String nomeQuartoJogador){

        Partida partida = partidaService.iniciaPartida(nomePrimeiroJogador, nomeSegundoJogador, nomeTerceiroJogador, nomeQuartoJogador);
        return ResponseEntity.ok(partida);
    }

}
