package com.renan.bjcarta.repositories;

import com.renan.bjcarta.entities.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {

}