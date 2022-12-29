package com.cac.mundialapi.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class EquipoDtoResp {
    private Long idTeam;
    private String country;
    private DirectorTecnicoDto dt;
    private Set<JugadorDtoResp> teamPlayers;
    private int worldCups;
}
