package com.sistema.apptreino.api.modulo.controller;


import com.sistema.apptreino.api.dao.TabDadosFisicoObj;
import com.sistema.apptreino.api.modulo.service.TabApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class TabApiController {




    @Autowired
    private TabApiService tabApiService;



    @GetMapping("/consultar/dadosFisico/{txHash}")
    private TabDadosFisicoObj consultaDadosFisico(){

        return new TabDadosFisicoObj();

    }


    @PostMapping ("/gravar/dadosFisico/{txHash}")
    private TabDadosFisicoObj gravarDadosFisico(){



        return new TabDadosFisicoObj();

    }


    @GetMapping("/gerar/planoTreino/{txHash}")
    private void gerarPlanoTreino(@PathVariable String txHash){





    }


    @PostMapping("/renovar/planoTreino/{txHash}")
    private void renovarPlanoTreino(@PathVariable String txHash){





    }


    @PostMapping("/substituir/exercicio/{txHash}")
    private void substituirExercicio(@PathVariable String txHash){





    }






}
