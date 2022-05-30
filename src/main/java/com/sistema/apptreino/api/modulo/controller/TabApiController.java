package com.sistema.apptreino.api.modulo.controller;

import com.sistema.apptreino.api.dao.TabDadosFisicoObj;
import com.sistema.apptreino.api.modulo.service.TabApiService;
import com.sistema.apptreino.dao.TabDadosFisicosUsuarioObj;
import com.sistema.apptreino.dao.TabUsuarioObj;
import com.sistema.apptreino.dao.bean.TabRetornoBean;
import com.sistema.apptreino.dao.repository.TabDadosFisicosUsuarioRepository;
import com.sistema.apptreino.modulos.administrador.cadastros.usuarios.service.usuario.TabUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api")
public class TabApiController {
    @Autowired
    private TabApiService tabApiService;

    @Autowired
    private TabUsuarioService tabUsuarioService;

    @Autowired
    private TabDadosFisicosUsuarioRepository tabDadosFisicosUsuarioRepository;

    @RequestMapping("/verifica")
    public @ResponseBody ResponseEntity<?> verifica() {
        return ResponseEntity.ok("Ok!");
    }

    @PostMapping("/usuario/gravar")
    public @ResponseBody ResponseEntity<?> gravarUsuario(@Validated @RequestBody TabUsuarioObj tabUsuarioObj) {
        List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
        if (tabUsuarioObj.getTxEmail() != null) {
            try {
                tabUsuarioObj.setDtCriacao(new Date());
                BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                String txPassword = bCryptPasswordEncoder.encode(tabUsuarioObj.getTxSenha());
                tabUsuarioObj.setTxSenha(txPassword);

                TabUsuarioObj usuarioObj = tabUsuarioService.gravar(tabUsuarioObj);

                return ResponseEntity.ok(usuarioObj);

            } catch (Exception ex) {
                TabRetornoBean erro = new TabRetornoBean();
                erro.setCdStatus(0);
                error.add(erro);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
            }
        } else {
            TabRetornoBean erro = new TabRetornoBean();
            erro.setCdStatus(0);
            erro.setTxRetorno(""); //Mensagem erro: já existe usuário com este e-mail
            error.add(erro);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
        }
    }

    @PostMapping("/usuario/dadosfisicos/gravar/{cdUsuario}")
    public @ResponseBody ResponseEntity<List<?>> gravarDadosFisicos(@Validated @RequestBody TabDadosFisicosUsuarioObj tabDadosFisicosUsuarioObj, Integer cdUsuario) {
        List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();

        TabUsuarioObj tabUsuarioObj = tabUsuarioService.buscar(cdUsuario);

        if (tabUsuarioObj != null) {
            try {
                tabDadosFisicosUsuarioObj.setCdUsuario(cdUsuario);
                tabDadosFisicosUsuarioRepository.save(tabDadosFisicosUsuarioObj);
                List<TabDadosFisicosUsuarioObj> Tab = new ArrayList<TabDadosFisicosUsuarioObj>();
                Tab.add(tabDadosFisicosUsuarioObj);
                return ResponseEntity.ok(Tab);

            } catch (Exception ex) {
                TabRetornoBean erro = new TabRetornoBean();
                erro.setCdStatus(0);
                error.add(erro);
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
            }
        } else {
            TabRetornoBean erro = new TabRetornoBean();
            erro.setCdStatus(0);
            error.add(erro);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
        }
    }


    @GetMapping("/consultar/dadosFisico/{txHash}")
    private TabDadosFisicoObj consultaDadosFisico() {
        return new TabDadosFisicoObj();
    }


    @GetMapping("/gerar/planoTreino/{txHash}")
    private void gerarPlanoTreino(@PathVariable String txHash) {
    }


    @PostMapping("/renovar/planoTreino/{txHash}")
    private void renovarPlanoTreino(@PathVariable String txHash) {
    }


    @PostMapping("/substituir/exercicio/{txHash}")
    private void substituirExercicio(@PathVariable String txHash) {
    }
}
