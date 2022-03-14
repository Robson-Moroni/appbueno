package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_divisao_conjunto", schema = "stb")
public class TabDivisaoConjuntoObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_divisao_conjunto")
    private Integer cdDivisaoConjunto;


    @Column(name = "tx_titulo")
    private String txTitulo;

    @ManyToOne
    @JoinColumn(name = "cd_divisao")
    private TabDivisaoObj cdDivisao;

    @ManyToOne
    @JoinColumn (name = "cd_conjunto")
    private TabConjuntoGrupoMuscularObj cdConjunto;


}
