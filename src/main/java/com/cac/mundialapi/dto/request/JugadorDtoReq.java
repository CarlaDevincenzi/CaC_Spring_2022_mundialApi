package com.cac.mundialapi.dto.request;

import com.cac.mundialapi.entity.Posicion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class JugadorDtoReq {
    private String name;
    private String lastName;
    private Posicion rolePlaying;
    private LocalDate birthDate;

    private int goals;

    public JugadorDtoReq(String name, String lastName, Posicion rolePlaying, LocalDate birthDate, int goals) {
        this.name = name;
        this.lastName = lastName;
        this.rolePlaying = rolePlaying;
        this.birthDate = birthDate;
        this.goals = goals;
        // setAge(calcularEdad)
    }

    /*
    * ACA EL METODO QUE CALCULA EDAD ?  -- PONER EN SERVICIO Y LO SETEA AL JUGADOR !!
    * CREAR OTRO DTO DE RESPUESTA CON TODOS LOS ATRIBUTOS
    * */
}
