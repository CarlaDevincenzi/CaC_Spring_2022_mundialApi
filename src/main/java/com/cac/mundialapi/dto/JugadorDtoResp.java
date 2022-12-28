package com.cac.mundialapi.dto;

import com.cac.mundialapi.entity.Equipo;
import com.cac.mundialapi.entity.Posicion;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JugadorDtoResp {
    private String name;
    private String lastName;
    private Posicion rolePlaying;
    private LocalDate birthDate;
    private int age;
    private int goals;
    //private Equipo equipo;
}
