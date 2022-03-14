package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_tecnica", schema = "stb")
public class TabTecnicaObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_tecnica")
    private Integer cdTecnica;


    @Column(name = "tx_tecnica")
    private String txTecnica;

    
}
