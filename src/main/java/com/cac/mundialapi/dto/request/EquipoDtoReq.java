package com.cac.mundialapi.dto.request;

import com.cac.mundialapi.dto.DirectorTecnicoDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class EquipoDtoReq {
    private Long idTeam;
    private String country;
    private DirectorTecnicoDto dt;
    private Set<JugadorDtoReq> teamPlayers; // --- SE CREA VACIO?
    private int worldCups;
}
