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
import com.uca.capas.parcial2.domain.Libro;
import com.uca.capas.parcial2.service.categoria.CategoriaService;
import com.uca.capas.parcial2.service.libro.LibroService;

@Controller
public class MainController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping("/")
	public String redirectInit() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
	public String init() {
		return "index";
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView ingresarCategoria() 
	{
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		
		mav.addObject("categoria", categoria);
		mav.setViewName("ingresarCategoria");
		
		return mav;
	}
	
	@RequestMapping("/guardarCategoria")
	public ModelAndView saveCategoria(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
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
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView ingresarLibro() 
	{
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> listaDeCategoria = null;
		
		try {
			listaDeCategoria = categoriaService.getAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		mav.addObject("libro", libro);
		mav.addObject("categorias", listaDeCategoria);
		mav.setViewName("ingresarLibro");
		
		return mav;
	}
	
	@RequestMapping("/guardarContribuyente")
	public ModelAndView save(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if(result.hasErrors()) 
		{
			List<Categoria> listaDeCategoria = null;
			
			try {
				listaDeCategoria = categoriaService.getAll();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("categorias", listaDeCategoria);
			mav.setViewName("index");
		}
		else 
		{
			libroService.save(libro);
			mav.addObject("exitoLibro", true);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping("/verLibros")
	public ModelAndView verLibros() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = null;
		
		try {
			libros = libroService.getAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("libros", libros);
		mav.setViewName("listadoLibros");
		
		return mav;
	}
	

}
