package com.sistema.apptreino.api.modulo.controller;

import com.sistema.apptreino.api.dao.TabDadosFisicoObj;
import com.sistema.apptreino.api.modulo.service.TabApiService;
import com.sistema.apptreino.dao.TabNivelTreinoObj;
import com.sistema.apptreino.dao.TabUsuarioObj;
import com.sistema.apptreino.dao.bean.TabRetornoBean;
import com.sistema.apptreino.modulos.administrador.cadastros.usuarios.service.usuario.TabUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api")
public class TabApiController {

    @Autowired
    private TabApiService tabApiService;

    @Autowired
    private TabUsuarioService tabUsuarioService;

    @PostMapping("/usuario/gravar")
    public @ResponseBody ResponseEntity<List<?>> gravarUsuario(@Validated TabUsuarioObj tabUsuarioObj, HttpServletRequest httpServletRequest, Errors erros){
        List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
        if(tabUsuarioObj.getTxEmail() != null) {
            try {
                tabUsuarioObj.setDtCriacao(new Date());
                tabUsuarioService.gravar(tabUsuarioObj);

                List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
                TabRetornoBean sucesso = new TabRetornoBean();
                sucesso.setCdStatus(1);
                success.add(sucesso);
                return ResponseEntity.ok(success);

            }
            catch (Exception ex) {
                TabRetornoBean erro = new TabRetornoBean();
                erro.setCdStatus(0);
                error.add(erro);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
            }
        }
        else {
            TabRetornoBean erro = new TabRetornoBean();
            erro.setCdStatus(0);
            erro.setTxRetorno(""); //Mensagem erro: já existe usuário com este e-mail
            error.add(erro);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
        }
    }


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
