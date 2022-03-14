package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_exercicio_tecnica", schema = "stb")
public class TabExercicioTecnicaObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_exercicio_tecnica")
    private Integer cdExercicioTecnica;

    @ManyToOne
    @JoinColumn(name = "cd_exercicio")
    private TabExercicioObj tabExercicioObj;

    @ManyToOne
    @JoinColumn(name = "cd_tecnica")
    private TabTecnicaObj tabTecnicaObj;

    
}
