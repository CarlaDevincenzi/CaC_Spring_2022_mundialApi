package com.cac.mundialapi.repository;

import com.cac.mundialapi.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_EquipoRepository extends JpaRepository<Equipo, Long> {
}
