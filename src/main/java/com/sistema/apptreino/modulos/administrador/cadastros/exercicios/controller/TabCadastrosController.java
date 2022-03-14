package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.controller;

import javax.servlet.http.HttpServletRequest;

import com.sistema.apptreino.dao.TabConjuntoGrupoMuscularObj;
import com.sistema.apptreino.dao.TabDivisaoObj;
import com.sistema.apptreino.dao.TabGrupoMuscularObj;
import com.sistema.apptreino.dao.TabNivelTreinoObj;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.TabDivisaoService;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.TabNivelTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.apptreino.TagConstants;

@Controller
@RequestMapping("/cadastro")
public class TabCadastrosController {


	@Autowired
	TabDivisaoService tabDivisaoService;

	@Autowired
	TabNivelTreinoService tabNivelTreinoService;


	private String txUrlTela = TagConstants.TAG_TEMPLATE_CADASTROS + "cadastros";

	@GetMapping
	public ModelAndView novo(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView(txUrlTela);
		carregarNovasInstancias(mv);
		carregarListas(mv);
		return mv;
	}

	private void carregarNovasInstancias(ModelAndView mv) {
		mv.addObject(new TabDivisaoObj());
		mv.addObject(new TabNivelTreinoObj());
		mv.addObject(new TabGrupoMuscularObj());
		mv.addObject(new TabConjuntoGrupoMuscularObj());

	}

	private void carregarListas(ModelAndView mv) {
		mv.addObject("listNivelTreino", tabNivelTreinoService.listar());
		mv.addObject("listDivisao", tabDivisaoService.listar());
	}



	@PostMapping("/gravar/nivelTreino")
	public ModelAndView gravarNivelTreino(@Validated TabNivelTreinoObj tabNivelTreinoObj, HttpServletRequest httpServletRequest, Errors errors){
		ModelAndView mv = new ModelAndView(txUrlTela);

		tabNivelTreinoService.gravar(tabNivelTreinoObj);
		return mv;
	}

	@PostMapping("/gravar/divisao")
	public ModelAndView gravarDivisao(@Validated TabDivisaoObj tabDivisaoObj, HttpServletRequest httpServletRequest, Errors errors){
		ModelAndView mv = new ModelAndView(txUrlTela);

		tabDivisaoService.gravar(tabDivisaoObj);

		return mv;
	}

}
