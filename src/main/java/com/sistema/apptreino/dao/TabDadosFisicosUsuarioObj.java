package com.sistema.apptreino.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tab_dados_fisicos", schema = "stb")
public class TabDadosFisicosUsuarioObj {

    @Id
    @GeneratedValue
    @Column(name = "cd_dados_fisicos")
    private Integer cdDadosFisicos;

    @Column(name = "cd_usuario")
    private Integer cdUsuario;

    @Column(name = "vl_altura")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlAltura;

    @Column(name = "vl_peso")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlPeso;

    @Column(name = "vl_peito")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlPeito;

    @Column(name = "vl_braco_direito")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlBracoDireito;

    @Column(name = "vl_braco_esquerdo")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlBracoEsquerdo;

    @Column(name = "vl_abdomen")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlAbdomen;

    @Column(name = "vl_cintura")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlCintura;

    @Column(name = "vl_gluteo")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlGluteo;

    @Column(name = "vl_coxa")
    //@NumberFormat(pattern = "#.##0,00")
    private Double vlCoxa;

    @Column(name = "tx_fuma")
    String txFuma;

    @Column(name = "tx_bebe")
    String txBebe;

    @Column(name = "tx_limitacoes")
    String txLimitacoes;

    @Column(name = "tx_nivel_esportivo")
    String txNivelEsportivo;

    @Column(name = "vl_qtd_treino_semana")
    Integer vlQtdTreinoSemana;

    @Column(name = "tx_objetivo_fisico")
    String txObjetivoFisico;

    @Column(name = "tx_foco_hipertrofia")
    String txFocoHipertrofia;

}