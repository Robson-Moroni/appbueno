package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_suporte_categoria", schema = "stb")
public class TabSuporteCategoriaObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_categoria")
    private Integer cdCategoria;


    @Column(name = "tx_categoria")
    private String txCategoria;

}
