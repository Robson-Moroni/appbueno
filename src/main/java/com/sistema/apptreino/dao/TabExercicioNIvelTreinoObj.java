package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_exercicio_nivel_treino", schema = "stb")
public class TabExercicioNIvelTreinoObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_exercicio_nivel_treino")
    private Integer cdExercicioNivelTreino;

    @ManyToOne
    @JoinColumn(name = "cd_exercicio")
    private TabExercicioObj tabExercicioObj;

    @ManyToOne
    @JoinColumn(name = "cd_nivel_treino")
    private TabNivelTreinoObj tabNivelTreinoObj;

}
