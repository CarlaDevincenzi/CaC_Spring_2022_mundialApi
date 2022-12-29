package com.cac.mundialapi.dto.request;

import com.cac.mundialapi.entity.Posicion;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
public class JugadorDtoReq {
    private String name;
    private String lastName;
    private Posicion rolePlaying;
    private LocalDate birthDate;
    private int goals;
    private EquipoDtoReq team;

}
