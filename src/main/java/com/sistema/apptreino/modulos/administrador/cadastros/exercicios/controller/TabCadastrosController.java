package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.controller;

import javax.servlet.http.HttpServletRequest;

import com.sistema.apptreino.dao.*;
import com.sistema.apptreino.dao.bean.TabRetornoBean;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.exercicios.*;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.suporte.TabSuporteCategoriaService;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.suporte.TabSuportePerguntaRespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.apptreino.TagConstants;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/cadastro")
public class TabCadastrosController {

	@Autowired
	private TabDivisaoService tabDivisaoService;

	@Autowired
	private TabNivelTreinoService tabNivelTreinoService;

	@Autowired
	private TabGrupoMuscularService tabGrupoMuscularService;

	@Autowired
	private TabExercicioService tabExercicioService;

	@Autowired
	private TabSerieService tabSerieService;

	@Autowired
	private TabSuporteCategoriaService tabSuporteCategoriaService;

	@Autowired
	private TabSuportePerguntaRespostaService tabSuportePerguntaRespostaService;

	private String txUrlTela = TagConstants.TAG_TEMPLATE_CADASTROS;

	@GetMapping
	public ModelAndView show(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView(txUrlTela + "cadastros");
		return mv;
	}

	/* Listagens */
	@GetMapping("/listar/divisao")
	public ModelAndView listarDivisoesTreino(){
		ModelAndView mv = new ModelAndView(txUrlTela + "exercicios/Divisao");
		mv.addObject("tabDivisaoObj", new TabDivisaoObj());
		mv.addObject("listDivisao", tabDivisaoService.listar());
		return mv;
	}

	@GetMapping("/listar/grupoMuscular")
	public ModelAndView listarGruposMusculares(){
		ModelAndView mv = new ModelAndView(txUrlTela + "exercicios/GrupoMuscular");
		mv.addObject(new TabGrupoMuscularObj());
		mv.addObject("listGrupoMuscular", tabGrupoMuscularService.listar());
		return mv;
	}

	@GetMapping("/listar/nivelTreino")
	public ModelAndView listarNivelTreino(HttpServletRequest request){
		ModelAndView mv = new ModelAndView(txUrlTela + "exercicios/NivelTreino");
		mv.addObject(new TabNivelTreinoObj());
		mv.addObject("listNivelTreino", tabNivelTreinoService.listar());

		return mv;
	}

	@GetMapping("/listar/exercicio")
	public ModelAndView listarExerciciosTreino(){
		ModelAndView mv = new ModelAndView(txUrlTela + "exercicios/exercicio");
		mv.addObject(new TabExercicioObj());
		mv.addObject("listExercicio", tabExercicioService.listar());
		return mv;
	}

	@GetMapping("/listar/serie")
	public ModelAndView listarSeriesTreino(){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "exercicios/series");
		mv.addObject(new TabSerieObj());
		mv.addObject("listSerie", tabSerieService.listar());
		return mv;
	}

	@GetMapping("/listar/suporteCategoria")
	public ModelAndView listarSuporteCategoria(){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "suporte/categoria");
		mv.addObject(new TabSuporteCategoriaObj());
		mv.addObject("listSuporteCategoria", tabSuporteCategoriaService.listar());
		return mv;
	}

	@GetMapping("/listar/suportePerguntaResposta")
	public ModelAndView listarSuportePerguntaResposta() {
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "suporte/categoria");
		mv.addObject(new TabSuportePerguntaRespostaObj());
		mv.addObject("listSuportePerguntaResposta", tabSuportePerguntaRespostaService.listar());
		return mv;
	}






	/* Consultas */

	@GetMapping("/consultar/nivelTreino/{cdNivelTreino}")
	public ModelAndView consultarNivelTreino(@PathVariable Integer cdNivelTreino){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "exercicios/NivelTreino");
		TabNivelTreinoObj tabNivelTreinoObj = tabNivelTreinoService.consultar(cdNivelTreino);
		mv.addObject("tabNivelTreinoObj", tabNivelTreinoObj);
		mv.addObject("listNivelTreino", tabNivelTreinoService.listar());
		mv.addObject("abrirModal", "modalNivelTreino");
		return mv;
	}

	@GetMapping("/consultar/grupomuscular/{cdGrupoMuscular}")
	public ModelAndView consultarGrupoMusucular(@PathVariable Integer cdGrupoMuscular){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "exercicios/GrupoMuscular");
		TabGrupoMuscularObj tabGrupoMuscularObj = tabGrupoMuscularService.consultar(cdGrupoMuscular);
		mv.addObject("tabGrupoMuscularObj", tabGrupoMuscularObj);
		mv.addObject("listGrupoMuscular", tabNivelTreinoService.listar());
		mv.addObject("abrirModal", "modalGrupoMuscular");
		return mv;
	}

	@GetMapping("/consultar/divisao/{cdDivisao}")
	public ModelAndView consultarDivisao(@PathVariable Integer cdDivisao){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "exercicios/Divisao");
		TabDivisaoObj tabDivisaoObj = tabDivisaoService.consultar(cdDivisao);
		mv.addObject("tabDivisaoObj", tabDivisaoObj);
		mv.addObject("listDivisao", tabDivisaoService.listar());
		mv.addObject("abrirModal", "modalDivisao");
		return mv;
	}


	/*Metodos de Gravação*/

	@PostMapping("/gravar/nivelTreino")
	public @ResponseBody List<?> gravarNivelTreino(@Validated TabNivelTreinoObj tabNivelTreinoObj, HttpServletRequest httpServletRequest, Errors erros){
		List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
		try {
			tabNivelTreinoService.gravar(tabNivelTreinoObj);
			List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
			TabRetornoBean sucesso = new TabRetornoBean();
			sucesso.setCdStatus(1);
			sucesso.setTxEndPointRetorno("/cadastro/listar/nivelTreino");
			success.add(sucesso);
			return success;

		}
		catch (Exception ex) {
			TabRetornoBean erro = new TabRetornoBean();
			erro.setCdStatus(0);
			error.add(erro);
			return error;
		}
	}

	@PostMapping("/gravar/grupoMuscular")
	public @ResponseBody List<?> gravarGrupoMuscular(@Validated TabGrupoMuscularObj tabGrupoMuscularObj, HttpServletRequest httpServletRequest, Errors erros){
		List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
		try {
			tabGrupoMuscularService.gravar(tabGrupoMuscularObj);
			List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
			TabRetornoBean sucesso = new TabRetornoBean();
			sucesso.setCdStatus(1);
			sucesso.setTxEndPointRetorno("/cadastro/listar/grupoMuscular");
			success.add(sucesso);
			return success;

		}
		catch (Exception ex) {
			TabRetornoBean erro = new TabRetornoBean();
			erro.setCdStatus(0);
			error.add(erro);
			return error;
		}
	}

	@PostMapping("/gravar/divisao")
	public @ResponseBody List<?> gravarDivisao(@Validated TabDivisaoObj tabDivisaoObj, HttpServletRequest httpServletRequest, Errors erros){
		List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
		try {
			tabDivisaoService.gravar(tabDivisaoObj);
			List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
			TabRetornoBean sucesso = new TabRetornoBean();
			sucesso.setCdStatus(1);
			sucesso.setTxEndPointRetorno("/cadastro/listar/divisao");
			success.add(sucesso);
			return success;

		}
		catch (Exception ex) {
			TabRetornoBean erro = new TabRetornoBean();
			erro.setCdStatus(0);
			error.add(erro);
			return error;
		}
	}

	@PostMapping("/gravar/exercicio")
	public @ResponseBody List<?> gravarExercicio(@Validated TabExercicioObj tabExercicioObj, HttpServletRequest httpServletRequest, Errors erros){
		List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
		try {
			tabExercicioService.gravar(tabExercicioObj);
			List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
			TabRetornoBean sucesso = new TabRetornoBean();
			sucesso.setCdStatus(1);
			sucesso.setTxEndPointRetorno("/cadastro/listar/exercicio");
			success.add(sucesso);
			return success;

		}
		catch (Exception ex) {
			TabRetornoBean erro = new TabRetornoBean();
			erro.setCdStatus(0);
			error.add(erro);
			return error;
		}
	}


	/*seleções que alimentam os seletores em tela */

	@ModelAttribute("selectGrupoMuscular")
	public List<TabGrupoMuscularObj> selectGrupoMuscular() {
		return tabGrupoMuscularService.listar();
	}

	@ModelAttribute("selectNiveisTreino")
	public List<TabNivelTreinoObj> selectNiveisTreino() {
		return tabNivelTreinoService.listar();
	}

	@ModelAttribute("selectDivisoes")
	public List<TabDivisaoObj> selectDivisao() {
		return tabDivisaoService.listar();
	}

	@ModelAttribute("selectSuporteCategoria")
	public List<TabSuporteCategoriaObj> selectSuporteCategoria(){ return tabSuporteCategoriaService.listar(); }
}