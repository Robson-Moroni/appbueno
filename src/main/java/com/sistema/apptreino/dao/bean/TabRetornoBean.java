package com.sistema.apptreino.dao.bean;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class TabRetornoBean {

    /* 0 - Erro ~ 1 - Sucesso*/
    private Integer cdStatus;

    private String txEndPointRetorno;

    private String txRetorno;

}
