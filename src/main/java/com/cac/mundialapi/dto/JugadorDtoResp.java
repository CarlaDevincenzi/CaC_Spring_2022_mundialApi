package com.cac.mundialapi.dto;

import com.cac.mundialapi.entity.Posicion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JugadorDtoResp {
    private String name;
    private String lastName;
    private Posicion rolePlaying;
    private LocalDate birthDate;
    private int age;
    private int goals;
}
