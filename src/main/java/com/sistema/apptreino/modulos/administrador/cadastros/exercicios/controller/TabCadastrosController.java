package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.controller;

import javax.servlet.http.HttpServletRequest;

import com.sistema.apptreino.dao.TabConjuntoGrupoMuscularObj;
import com.sistema.apptreino.dao.TabDivisaoObj;
import com.sistema.apptreino.dao.TabGrupoMuscularObj;
import com.sistema.apptreino.dao.TabNivelTreinoObj;
import com.sistema.apptreino.dao.bean.TabRetornoBean;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.TabDivisaoService;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.TabGrupoMuscularService;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.TabNivelTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.apptreino.TagConstants;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@EnableAsync
@Controller
@RequestMapping("/cadastro")
public class TabCadastrosController {


    @Autowired
    TabDivisaoService tabDivisaoService;

    @Autowired
    TabNivelTreinoService tabNivelTreinoService;

    @Autowired
    TabGrupoMuscularService tabGrupoMuscularService;


    private String txUrlTela = TagConstants.TAG_TEMPLATE_CADASTROS;

    @GetMapping
    public ModelAndView novo(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView(txUrlTela + "cadastros");
        return mv;
    }

    private void carregarNovasInstancias(ModelAndView mv, String element) {

        switch (element) {
            case "Divisao":
                mv.addObject(new TabDivisaoObj());
                break;
            case "NivelTreino":
                mv.addObject(new TabNivelTreinoObj());
                break;
            case "GrupoMuscular":
                mv.addObject(new TabGrupoMuscularObj());
                break;
            case "ConjuntoGrupoMuscular":
                mv.addObject(new TabConjuntoGrupoMuscularObj());
                break;
        }
    }

    private void carregarListDados(ModelAndView mv, String element) {

        switch (element) {
            case "Divisao":
                mv.addObject("list" + element, tabDivisaoService.listar());
                break;
            case "NivelTreino":
                mv.addObject("list" + element, tabNivelTreinoService.listar());
                break;

            case "GrupoMuscular":
                mv.addObject("list" + element, tabGrupoMuscularService.listar());
                break;
        }

    }


    @GetMapping("/listar/{element}")
    public ModelAndView listarNivelTreino(@PathVariable String element) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ModelAndView mv = new ModelAndView(txUrlTela + "exercicios/" + element);

        carregarNovasInstancias(mv, element);
        carregarListDados(mv, element);
        return mv;
    }


    @PostMapping("/gravar/nivelTreino")
    public @ResponseBody
    List<?> gravarNivelTreino(@Validated TabNivelTreinoObj tabNivelTreinoObj, HttpServletRequest httpServletRequest, Errors erros) {
        List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
        try {
            tabNivelTreinoService.gravar(tabNivelTreinoObj);
            List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
            TabRetornoBean sucesso = new TabRetornoBean();
            sucesso.setCdStatus(1);
            sucesso.setTxEndPointRetorno("/cadastro/listar/NivelTreino");
            success.add(sucesso);
            return success;

        } catch (Exception ex) {
            TabRetornoBean erro = new TabRetornoBean();
            erro.setCdStatus(0);
            error.add(erro);
            return error;
        }
    }


    @PostMapping("/gravar/divisao")
    public @ResponseBody
    List<?> gravarDivisao(@Validated TabDivisaoObj tabDivisaoObj, HttpServletRequest httpServletRequest, Errors erros) {
        List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
        try {
            tabDivisaoService.gravar(tabDivisaoObj);
            List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
            TabRetornoBean sucesso = new TabRetornoBean();
            sucesso.setCdStatus(1);
            sucesso.setTxEndPointRetorno("/cadastro/listar/Divisao");
            success.add(sucesso);
            return success;

        } catch (Exception ex) {
            TabRetornoBean erro = new TabRetornoBean();
            erro.setCdStatus(0);
            error.add(erro);
            return error;
        }
    }


    @PostMapping("/gravar/grupoMuscular")
    public @ResponseBody
    List<?> gravarGrupoMuscular(@Validated TabGrupoMuscularObj tabGrupoMuscularObj, HttpServletRequest httpServletRequest, Errors erros) {
        List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
        try {
            tabGrupoMuscularService.gravar(tabGrupoMuscularObj);
            List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
            TabRetornoBean sucesso = new TabRetornoBean();
            sucesso.setCdStatus(1);
            sucesso.setTxEndPointRetorno("/cadastro/listar/GrupoMuscular");
            success.add(sucesso);
            return success;

        } catch (Exception ex) {
            TabRetornoBean erro = new TabRetornoBean();
            erro.setCdStatus(0);
            error.add(erro);
            return error;
        }
    }


    //	@GetMapping("/listar/{element}")
//	public ModelAndView listarNivelTreino(@PathVariable String element) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//		ModelAndView mv = new ModelAndView(txUrlTela + "exercicios/" + element );
//
//		String service = "modulos.administrador.cadastros.exercicios.service.Tab" + element + "Service";
//		String obj = "dao.Tab" + element + "Obj";
//
//		RequestReflection reflectionService = new RequestReflection(service);
//		reflectionService.requestMethod("listar");
//
//		Object list = reflectionService.invocarMetodo();
//
//		carregarNovasInstancias(mv);
//		mv.addObject("list"+element, list);
//		return mv;
//	}


}
