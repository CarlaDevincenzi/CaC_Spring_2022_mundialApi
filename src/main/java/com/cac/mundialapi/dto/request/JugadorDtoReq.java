package com.cac.mundialapi.dto.request;

import com.cac.mundialapi.entity.Posicion;
import com.cac.mundialapi.utils.BeforeDate;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;

@Getter @Setter
public class JugadorDtoReq {
    private String name;
    private String lastName;
    private Posicion rolePlaying;

    /*
        @BeforeDate = annotation propia creada para validar que a noviembre de 2022 el jugador
        ya sea mayor a 18 años
     */
    @BeforeDate(current = "2004-11-01", message = "El jugador no puede ser menor a 18 años")
    private LocalDate birthDate;

    @PositiveOrZero(message = "Goles no puede tener un valor negativo")
    private int goals;
    private EquipoDtoReq team;

}
