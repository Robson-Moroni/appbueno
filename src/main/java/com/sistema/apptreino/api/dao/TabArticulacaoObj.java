package com.sistema.apptreino.api.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "tab_articulacao", schema = "stb")
public class TabArticulacaoObj {


    @Id
    @GeneratedValue
    @Column(name = "cd_articulacao")
    private Integer cdArticulacao;


    @Column(name = "tx_articulacao")
    private String txArticulacao;
}
