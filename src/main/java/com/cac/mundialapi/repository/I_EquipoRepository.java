package com.cac.mundialapi.repository;

import com.cac.mundialapi.entity.Equipo;
import com.cac.mundialapi.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface I_EquipoRepository extends JpaRepository<Equipo, Long> {
    List<Equipo> findAllByOrderByCountryAsc();
}
