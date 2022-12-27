package com.cac.mundialapi.repository;

import com.cac.mundialapi.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_JugadorRepository extends JpaRepository<Jugador, Long> {
}
