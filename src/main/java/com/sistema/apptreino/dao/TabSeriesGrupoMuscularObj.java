package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_serie_grupo_muscular", schema = "stb")
public class TabSeriesGrupoMuscularObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_serie_grupo_muscular")
    private Integer cdSerieGrupoMuscular;


    @ManyToOne
    @JoinColumn(name = "cd_serie")
    private TabSerieObj tabSerieObj;

    @ManyToOne
    @JoinColumn(name = "cd_grupo_muscular")
    private TabGrupoMuscularObj tabGrupoMuscularObj;

    @ManyToOne
    @JoinColumn(name = "cd_nivel_treino")
    private TabNivelTreinoObj tabNivelTreinoObj;


}
