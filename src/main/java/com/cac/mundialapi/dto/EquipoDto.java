package com.cac.mundialapi.dto;

import com.cac.mundialapi.dto.request.JugadorDtoReq;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EquipoDto {
    private Long idTeam;
    private String country;
    private DirectorTecnicoDto dt;
    private Set<JugadorDtoReq> teamPlayers; // --- SE CREA VACIO?
    private int worldCups;
}
