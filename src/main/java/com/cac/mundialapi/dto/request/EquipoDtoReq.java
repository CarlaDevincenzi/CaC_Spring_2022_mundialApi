package com.cac.mundialapi.dto.request;

import com.cac.mundialapi.dto.DirectorTecnicoDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Getter
@Setter
public class EquipoDtoReq {
    private Long idTeam;

    @NotNull(message = "Debe ingresar el nombre del pais!!")
    @NotBlank(message = "Debe ingresar el nombre del pais!!")
    private String country;

    @NotNull(message = "No puede ingresar un Equipo sin su Director Tecnico designado")
    private DirectorTecnicoDto dt;

    private List<JugadorDtoReq> teamPlayers;

    @PositiveOrZero(message = "WorldCups no puede tener un valor negativo")
    private int worldCups;
}
