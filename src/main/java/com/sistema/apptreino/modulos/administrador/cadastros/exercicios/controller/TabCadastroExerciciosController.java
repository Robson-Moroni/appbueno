package com.sistema.apptreino.modulos.administrador.cadastros.exercicios.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistema.apptreino.TagConstants;

@Controller
@RequestMapping("/cadastro")
public class TabCadastroExerciciosController {

	private String txUrlTela = TagConstants.TAG_TEMPLATE_CADASTROS + "exercicios";

	@GetMapping
	public ModelAndView novo(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView(txUrlTela);
		mv.addObject("Hello", "HelloWorld");
		return mv;
	}

}
