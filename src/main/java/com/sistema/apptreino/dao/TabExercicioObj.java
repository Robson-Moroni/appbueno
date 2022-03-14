package com.sistema.apptreino.dao;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_exercicio", schema = "stb")
public class TabExercicioObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_exercicio")
    private Integer cdExercicio;


    @Column(name = "tx_nome_exercicio")
    private String txNomeExercicio;


    @Column(name = "ds_exercicio")
    private String dsExercicio;


    @Column(name = "tx_caminho_banner")
    private String txCaminhoBanner;


    @Column(name = "tx_caminho_video")
    private String txCaminhoVideo;

    @Column(name = "tx_img_demonstrativa_exercicio")
    private String txImgDemonstrativaExercicio;

    @ManyToOne
    @JoinColumn (name = "cd_grupo_muscular")
    private TabGrupoMuscularObj tabGrupoMuscularObj;





}
