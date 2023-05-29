package com.renan.bjcarta.repositories;

import com.renan.bjcarta.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

}