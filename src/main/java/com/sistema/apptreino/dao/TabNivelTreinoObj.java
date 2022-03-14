package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_nivel_treino", schema = "stb")
public class TabNivelTreinoObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_nivel_treino")
    private Integer cdGrupoMuscular;


    @Column(name = "tx_nivel_treino")
    private String txNivelTreino;


    @Column(name = "ds_nivel_treino")
    private String dsNivelTreino;

    
}
