package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_conjunto_grupo_muscular", schema = "stb")
public class TabConjuntoGrupoMuscularObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_conjunto_grupo_muscular")
    private Integer cdConjuntoGrupoMuscular;


    @ManyToOne
    @JoinColumn(name = "cd_conjunto")
    private TabConjuntoGrupoMuscularObj tabConjuntoObj;


    @Column(name = "cd_grupo_muscular")
    private Integer cdGrupoMuscular;

}
