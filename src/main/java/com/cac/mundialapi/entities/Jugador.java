package com.cac.mundialapi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Jugador {
    private String name;
    private String lastName;
    private Posicion rolePlaying;
    private LocalDate birthDate;
    private int age;
    private int goals;

    public Jugador(String name, String lastName, Posicion rolePlaying, LocalDate birthDate, int goals) {
        this.name = name;
        this.lastName = lastName;
        this.rolePlaying = rolePlaying;
        this.birthDate = birthDate;
        this.goals = goals;
    }
}
