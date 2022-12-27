package com.cac.mundialapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeam;

    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dt_id", nullable = false)
    private DirectorTecnico dt;

    @OneToMany(mappedBy = "team")
    private Set<Jugador> teamPlayers;

    private int worldCups;



}
