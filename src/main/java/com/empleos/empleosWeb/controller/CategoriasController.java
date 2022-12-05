package com.empleos.empleosWeb.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empleos.empleosWeb.model.Categoria;
import com.empleos.empleosWeb.service.IntCategoriasService;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	private IntCategoriasService serviceCategorias;
	
	@PostMapping("/guardar")
	public String guardar(@Valid Categoria categoria,BindingResult result, RedirectAttributes atributo, RedirectAttributes model) {
		if(result.hasErrors()) {
			System.out.println("Error");
			return "categorias/formCategoria";
		}else {
		//System.out.println(categoria);
		if ( categoria.getId() == null) {
			int index = serviceCategorias.obtenerTodas().size()-1;
			Categoria aux = serviceCategorias.obtenerTodas().get(index);
			categoria.setId(aux.getId()+1);
			serviceCategorias.guardar(categoria);
			model.addFlashAttribute("msg", "Se guardo la categoria");
		}else {
			int index = serviceCategorias.obtenerTodas().size()-1;
			Categoria aux = serviceCategorias.obtenerTodas().get(index);
			serviceCategorias.guardar(categoria);
			model.addFlashAttribute("msg", "Se modifico³ la categoria");
		}
	/*	categoria.setId(categoriaService.obtenerTodas().size()+1);
		System.out.println(categoria);
		categoriaService.agregar(categoria);*/
		
		return "redirect:/categorias/index";
		}
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") int idCategoria,RedirectAttributes atributo) {
		serviceCategorias.eliminar(idCategoria);
		atributo.addFlashAttribute("msg","Categoria eliminada");
		return "redirect:/categorias/index";
	}
	@GetMapping("/crear")
	public String nuevaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categorias/formCategoria";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = serviceCategorias.obtenerTodas();
		for(Categoria c : lista) {
			System.out.println(c);
		}
		model.addAttribute("categorias",lista);
		return "categorias/listCategorias";
	}
	
	@GetMapping("/consultar")
	public String consultar(@RequestParam("id")int idCategoria,Model model) {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria",categoria);
		return "categorias/formCategoria";
	}

	
}
