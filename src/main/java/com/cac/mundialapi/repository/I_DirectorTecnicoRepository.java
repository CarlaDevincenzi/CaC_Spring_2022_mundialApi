package com.cac.mundialapi.repository;

import com.cac.mundialapi.entity.DirectorTecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface I_DirectorTecnicoRepository extends JpaRepository<DirectorTecnico, Long> {
}
