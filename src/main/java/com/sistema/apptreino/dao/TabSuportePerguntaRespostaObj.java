package com.sistema.apptreino.dao;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tab_suporte_pergunta_resposta", schema = "stb")
public class TabSuportePerguntaRespostaObj {

    @Id
    @Column(name = "cd_pergunta_resposta")
    private int cdPerguntaResposta;

    @Column(name = "tx_pergunta")
    private String txPergunta;

    @Column(name = "tx_resposta")
    private String txResposta;

    @ManyToOne
    @JoinColumn(name = "cd_suporte_categoria")
    private TabSuporteCategoriaObj tabSuporteCategoriaObj;

}
