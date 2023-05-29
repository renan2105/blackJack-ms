package com.renan.bjcarta.services;

import com.renan.bjcarta.entities.Jogador;
import com.renan.bjcarta.entities.enums.StatusJogadorEnum;
import com.renan.bjcarta.repositories.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;


//    public Partida iniciaPartida(String nomePrimeiroJogador, String nomeSegundoJogador, String nomeTerceiroJogador,
//                                 String nomeQuartoJogador){
//
//
//
//        Partida partida = new Partida(null,
//                criaJogadores(Arrays.asList(nomePrimeiroJogador,nomeSegundoJogador,nomeTerceiroJogador,nomeQuartoJogador)),
//                StatusPartidaEnum.PROGRESSO,
//                null,
//                )
//
//    }

    public List<Jogador> criaJogadores(List<String> nomeJogadores){

        List<Jogador> jogadores = new ArrayList<>();

        nomeJogadores.forEach(jogador-> jogadores.add(new Jogador(jogador,
                0,
                new ArrayList<>(),
                StatusJogadorEnum.JOGANDO)));

        return jogadores;
    }

//    private List<Carta> criaBaralho(){
//
//        List<Carta> baralho = new ArrayList<>();
//
//        for(int i = 1; i < 13; i++){
//
//
//
//        }
//
//        baralho.add(new Carta("ESPAD", "A", 1));
//        baralho.add(new Carta("PAUSS", "A", 1));
//        baralho.add(new Carta("COPAS", "A", 1));
//        baralho.add(new Carta("OUROS", "A", 1));
//
//        baralho.add(new Carta("ESPAD", "2", 2));
//        baralho.add(new Carta("PAUSS", "2", 2));
//        baralho.add(new Carta("COPAS", "2", 2));
//        baralho.add(new Carta("OUROS", "2", 2));
//
//        baralho.add(new Carta("ESPAD", "3", 3));
//        baralho.add(new Carta("PAUSS", "3", 3));
//        baralho.add(new Carta("COPAS", "3", 3));
//        baralho.add(new Carta("OUROS", "3", 3));
//
//        baralho.add(new Carta("ESPAD", "4", 4));
//        baralho.add(new Carta("PAUSS", "4", 4));
//        baralho.add(new Carta("COPAS", "4", 4));
//        baralho.add(new Carta("OUROS", "4", 4));
//
//        baralho.add(new Carta("ESPAD", "5", 5));
//        baralho.add(new Carta("PAUSS", "5", 5));
//        baralho.add(new Carta("COPAS", "5", 5));
//        baralho.add(new Carta("OUROS", "5", 5));
//
//        baralho.add(new Carta("ESPAD", "6", 6));
//        baralho.add(new Carta("PAUSS", "6", 6));
//        baralho.add(new Carta("COPAS", "6", 6));
//        baralho.add(new Carta("OUROS", "6", 6));
//
//        baralho.add(new Carta("ESPAD", "7", 7));
//        baralho.add(new Carta("PAUSS", "7", 7));
//        baralho.add(new Carta("COPAS", "7", 7));
//        baralho.add(new Carta("OUROS", "7", 7));
//
//        baralho.add(new Carta("ESPAD", "8", 8));
//        baralho.add(new Carta("PAUSS", "8", 8));
//        baralho.add(new Carta("COPAS", "8", 8));
//        baralho.add(new Carta("OUROS", "8", 8));
//
//        baralho.add(new Carta("ESPAD", "9", 9));
//        baralho.add(new Carta("PAUSS", "9", 9));
//        baralho.add(new Carta("COPAS", "9", 9));
//        baralho.add(new Carta("OUROS", "9", 9));
//
//        baralho.add(new Carta("ESPAD", "10", 10));
//        baralho.add(new Carta("PAUSS", "10", 10));
//        baralho.add(new Carta("COPAS", "10", 10));
//        baralho.add(new Carta("OUROS", "10", 10));
//
//        baralho.add(new Carta("ESPAD", "K", 11));
//        baralho.add(new Carta("PAUSS", "K", 11));
//        baralho.add(new Carta("COPAS", "K", 11));
//        baralho.add(new Carta("OUROS", "K", 11));
//
//        baralho.add(new Carta("ESPAD", "J", 11));
//        baralho.add(new Carta("PAUSS", "J", 11));
//        baralho.add(new Carta("COPAS", "J", 11));
//        baralho.add(new Carta("OUROS", "J", 11));
//
//        baralho.add(new Carta("ESPAD", "Q", 11));
//        baralho.add(new Carta("PAUSS", "Q", 11));
//        baralho.add(new Carta("COPAS", "Q", 11));
//        baralho.add(new Carta("OUROS", "Q", 11));
//
//        return baralho;
//
//    }
}
