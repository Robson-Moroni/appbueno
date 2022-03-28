package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_divisao", schema = "stb")
public class TabDivisaoObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_divisao")
    private Integer cdDivisao;


    @Column(name = "tx_sexo_divisao")
    private String txSexoDivisao;


    @Column(name = "sg_divisao")
    private String sgDivisao;


}
