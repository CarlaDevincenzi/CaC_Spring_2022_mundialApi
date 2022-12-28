package com.cac.mundialapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private Long idPlayer;

    private String name;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Posicion rolePlaying;

    private LocalDate birthDate;
    private int age;
    private int goals;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Equipo team;

}
