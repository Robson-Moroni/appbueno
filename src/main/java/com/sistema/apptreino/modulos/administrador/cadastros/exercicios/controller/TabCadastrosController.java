package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.controller;

import javax.servlet.http.HttpServletRequest;

import com.sistema.apptreino.dao.*;
import com.sistema.apptreino.dao.bean.TabRetornoBean;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.exercicios.*;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.suporte.TabSuporteCategoriaService;
import com.sistema.apptreino.modulos.administrador.cadastros.exercicios.service.suporte.TabSuportePerguntaRespostaService;
import org.springframework.beans.factory.annotation.Autowired;
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

	private String txUrlTela = TagConstants.TAG_TEMPLATE_CADASTROS + "cadastros";

	@GetMapping
	public ModelAndView show(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView(txUrlTela);
		//carregarNovasInstancias(mv);
		return mv;
	}

	/*private void carregarNovasInstancias(ModelAndView mv) {
		mv.addObject(new TabDivisaoObj());
		mv.addObject(new TabNivelTreinoObj());
		mv.addObject(new TabGrupoMuscularObj());
		mv.addObject(new TabConjuntoGrupoMuscularObj());

	}*/

	/* Listagens */
	@GetMapping("/divisoesTreino/listar")
	public ModelAndView listarDivisoesTreino(){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "/exercicios/divisoes");
		mv.addObject("tabDivisaoObj", new TabDivisaoObj());
		mv.addObject("listDivisao", tabDivisaoService.listar());
		return mv;
	}

	@GetMapping("/gruposMusculares/listar")
	public ModelAndView listarGruposMusculares(){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "/exercicios/gruposmusculares");
		mv.addObject("tabGrupoMuscularesObj", new TabGrupoMuscularObj());
		mv.addObject("listGrupoMuscular", tabGrupoMuscularService.listar());
		return mv;
	}

	@GetMapping("/nivelTreino/listar")
	public ModelAndView listarNivelTreino(HttpServletRequest request){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "/exercicios/niveistreino");
		mv.addObject("tabNivelTreinoObj", new TabNivelTreinoObj());
		mv.addObject("listNivelTreino", tabNivelTreinoService.listar());

		if (request.getParameter("novo") != null) {
			mv.addObject("abrirModal", "modalNivelTreino");
		}

		return mv;
	}

	@GetMapping("/exerciciosTreino/listar")
	public ModelAndView listarExerciciosTreino(){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "/exercicios/exercicio");
		mv.addObject("tabExercicioObj", new TabExercicioObj());
		mv.addObject("listExercicio", tabExercicioService.listar());
		return mv;
	}

	@GetMapping("/seriesTreino/listar")
	public ModelAndView listarSeriesTreino(){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "/exercicios/series");
		mv.addObject("tabSerieObj", new TabSerieObj());
		mv.addObject("listSerie", tabSerieService.listar());
		return mv;
	}

	@GetMapping("/suporteCategoria/listar")
	public ModelAndView listarSuporteCategoria(){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "/suporte/categoria");
		mv.addObject("tabSuporteCategoriaObj", new TabSuporteCategoriaObj());
		mv.addObject("listSuporteCategoria", tabSuporteCategoriaService.listar());
		return mv;
	}

	@GetMapping("/suportePerguntaResposta/listar")
	public ModelAndView listarSuportePerguntaResposta() {
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "/suporte/categoria");
		mv.addObject("tabSuportePerguntaRespostaObj", new TabSuportePerguntaRespostaObj());
		mv.addObject("listSuportePerguntaResposta", tabSuportePerguntaRespostaService.listar());
		return mv;
	}

	/* Consultas */

	@GetMapping("/nivelTreino/consultar/{cdNivelTreino}")
	public ModelAndView novoNivelTreino(@PathVariable Integer cdNivelTreino){
		ModelAndView mv = new ModelAndView(TagConstants.TAG_TEMPLATE_CADASTROS + "/exercicios/niveistreino");
		TabNivelTreinoObj tabNivelTreinoObj = tabNivelTreinoService.consultar(cdNivelTreino);
		mv.addObject("tabNivelTreinoObj", tabNivelTreinoObj);
		mv.addObject("listNivelTreino", tabNivelTreinoService.listar());
		mv.addObject("abrirModal", "modalNivelTreino");
		return mv;
	}

	@PostMapping("/nivelTreino/gravar")
	public @ResponseBody List<?> gravarNivelTreino(@Validated TabNivelTreinoObj tabNivelTreinoObj, HttpServletRequest httpServletRequest, Errors erros){
		List<TabRetornoBean> error = new ArrayList<TabRetornoBean>();
		try {
			tabNivelTreinoService.gravar(tabNivelTreinoObj);
			List<TabRetornoBean> success = new ArrayList<TabRetornoBean>();
			TabRetornoBean sucesso = new TabRetornoBean();
			sucesso.setCdStatus(1);
			sucesso.setTxEndPointRetorno("/cadastro/nivelTreino/listar");
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
	public ModelAndView gravarDivisao(@Validated TabDivisaoObj tabDivisaoObj, HttpServletRequest httpServletRequest, Errors errors){
		ModelAndView mv = new ModelAndView(txUrlTela);

		tabDivisaoService.gravar(tabDivisaoObj);

		return mv;
	}

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