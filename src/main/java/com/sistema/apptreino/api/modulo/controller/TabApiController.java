package com.sistema.apptreino.api.modulo.controller;


import com.sistema.apptreino.api.dao.TabDadosFisicoObj;
import com.sistema.apptreino.api.modulo.service.TabApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TabApiController {




    @Autowired
    private TabApiService tabApiService;



    @GetMapping("/consultar/dadosFisico")
    private TabDadosFisicoObj consultaDadosFisico(){

        return new TabDadosFisicoObj();

    }


    @GetMapping("/gravar/dadosFisico")
    private TabDadosFisicoObj gravarDadosFisico(){



        return new TabDadosFisicoObj();

    }

}
