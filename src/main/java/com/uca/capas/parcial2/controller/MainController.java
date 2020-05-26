package com.uca.capas.parcial2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.parcial2.domain.Categoria;
import com.uca.capas.parcial2.service.categoria.CategoriaService;

@Controller
public class MainController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping("/")
	public String redirectInit() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String init() {
		return "index";
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView initMain() 
	{
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		
		mav.addObject("categoria", categoria);
		mav.setViewName("ingresarCategoria");
		
		return mav;
	}
	
	@RequestMapping("/guardarCategoria")
	public ModelAndView save(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) 
		{
			mav.setViewName("ingresarCategoria");
		}
		else 
		{
			categoriaService.save(categoria);
			mav.addObject("exitoCategoria", true);
			mav.setViewName("index");
		}
		
		return mav;
	}
	

}
