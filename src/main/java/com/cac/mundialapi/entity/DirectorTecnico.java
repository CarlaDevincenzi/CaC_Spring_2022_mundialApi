package com.cac.mundialapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "dir_tecnicos")
public class DirectorTecnico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dt")
    private Long id_DT;

    private String name;
    private String lastName;
    private String originCountry;

    @OneToOne(mappedBy = "dt")
    private Equipo team;
}
