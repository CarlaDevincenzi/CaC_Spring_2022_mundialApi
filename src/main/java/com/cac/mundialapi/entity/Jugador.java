package com.cac.mundialapi.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlayer;

    private String name;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Posicion rolePlaying;

    private LocalDate birthDate;
    private int age;
    private int goals;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Equipo team;

    /*
    public Jugador(String name, String lastName, Posicion rolePlaying, LocalDate birthDate, int goals) {
        this.name = name;
        this.lastName = lastName;
        this.rolePlaying = rolePlaying;
        this.birthDate = birthDate;
        this.goals = goals;
    }
    */

}
