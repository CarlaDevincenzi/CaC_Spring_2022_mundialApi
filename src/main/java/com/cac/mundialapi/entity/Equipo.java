package com.cac.mundialapi.entity;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "equipos")
public class Equipo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team")
    private Long idTeam;

    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dt_id")
    private DirectorTecnico dt;

    @OneToMany(mappedBy = "team", orphanRemoval = true)
    private List<Jugador> teamPlayers;

    private int worldCups;



}
