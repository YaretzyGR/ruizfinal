package com.empleos.empleosWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.empleos.empleosWeb.model.Categoria;
import com.empleos.empleosWeb.model.Vacante;
import com.empleos.empleosWeb.service.IntCategoriasService;
import com.empleos.empleosWeb.service.IntVacantesService;

@Controller
public class HomeController {

	@Autowired
	private IntVacantesService vacantesService;
	@Autowired
	private IntCategoriasService CategoriasServceImp;
	
	@GetMapping("/")
	String mostrarIndex(Model model) {
		List<Vacante> lista = vacantesService.obtenerTodas();
		List<Categoria> catego = CategoriasServceImp.obtenerTodas();
		model.addAttribute("vacantes", lista);
		model.addAttribute("categorias", catego);
		return "home";
	}
}
