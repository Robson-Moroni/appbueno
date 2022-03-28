package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_serie", schema = "stb")
public class TabSerieObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_serie")
    private Integer cdSerie;

    @ManyToOne
    @JoinColumn(name = "cd_nivel_treino")
    private TabNivelTreinoObj tabNivelTreinoObj;

    @Column(name = "qt_exercicios_dia_serie")
    private Integer qtExerciciosDiaSerie;


    @Column(name = "qt_min_series_semana")
    private Integer qtMinSeriesSemana;


    @Column(name = "qt_max_series_semana")
    private Integer qtMaxSeriesSemana;


    @Column(name = "qt_min_repeticao")
    private Integer qtMinRepeticao;


    @Column(name = "qt_max_repeticao")
    private Integer qtMaxRepeticao;


    @Column(name = "qt_min_tempo_descanso")
    private Integer qtMinTempoDescanso;


    @Column(name = "qt_max_tempo_descanso")
    private Integer qtMaxTempoDescanso;



}
