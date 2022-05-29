package com.sistema.apptreino.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tab_usuario", schema = "stb")
public class TabUsuarioObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cd_usuario")
    private Integer cdUsuario;

    @Column(name = "tx_nome")
    private String txNome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_nascimento")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    @Transient
    private String txGenero;

    @Column(name = "tx_telefone")
    private String txTelefone;

    @Column(name = "tx_email")
    private String txEmail;

    @Column(name = "tx_senha")
    private String txSenha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_criacao")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCriacao;

}
