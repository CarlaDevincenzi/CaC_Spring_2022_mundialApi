package com.cac.mundialapi.dto;

import com.cac.mundialapi.dto.request.JugadorDtoReq;

import java.util.Set;

public class EquipoDto {
    private String country;
    private DirectorTecnicoDto dt;
    private Set<JugadorDtoReq> teamPlayers; // --- SE CREA VACIO?
    private int worldCups;
}
