package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_grupo_muscular", schema = "stb")
public class TabGrupoMuscularObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_grupo_muscular")
    private Integer cdGrupoMuscular;


    @Column(name = "tx_grupo_muscular")
    private String txGrupoMuscular;


    @Column(name = "tx_caminho_imagem_demonstrativo")
    private String txCaminhoImagemDemonstrativo;

    
}
