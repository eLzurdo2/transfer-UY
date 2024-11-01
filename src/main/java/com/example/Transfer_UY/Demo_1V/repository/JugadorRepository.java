package com.example.Transfer_UY.Demo_1V.repository;

import com.example.Transfer_UY.Demo_1V.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
}

