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

import com.empleos.empleosWeb.model.Usuario;
import com.empleos.empleosWeb.service.IntUsuariosService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private IntUsuariosService serviceUsuarios;
	
	@PostMapping("/guardar")
	public String guardar(@Valid Usuario categoria,BindingResult result, RedirectAttributes atributo, RedirectAttributes model) {
		if(result.hasErrors()) {
			System.out.println("Error");
			return "categorias/formCategoria";
		}else {
		//System.out.println(categoria);
		if ( categoria.getId() != 1) {
			int index = serviceUsuarios.obtenerTodas().size()-1;
			Usuario aux = serviceUsuarios.obtenerTodas().get(index);
			categoria.setId(aux.getId()+1);
			serviceUsuarios.agregar(categoria);
			model.addFlashAttribute("msg", "Se guardo la categoria");
		}else {
			int index = serviceUsuarios.obtenerTodas().size()-1;
			Usuario aux = serviceUsuarios.obtenerTodas().get(index);
			serviceUsuarios.agregar(categoria);
			model.addFlashAttribute("msg", "Se modifico³ la categoria");
		}
	/*	categoria.setId(categoriaService.obtenerTodas().size()+1);
		System.out.println(categoria);
		categoriaService.agregar(categoria);*/
		
		return "redirect:/usuarios/index";
		}
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Usuario> lista = serviceUsuarios.obtenerTodas();
		for(Usuario u : lista) {
			System.out.println(u);
		}
		model.addAttribute("usuarios", lista);
		return "usuarios/listUsuarios";
	}
	
	@GetMapping("/consultar")
	public String consultar(@RequestParam("id")int idCategoria,Model model) {
		Usuario usuario = serviceUsuarios.buscarPorId(idCategoria);
		model.addAttribute("usuarios",usuario);
		return "usuarios/formCategoria";
	}
	
	@GetMapping("/crear")
	public String nuevaCategoria(Model model) {
		model.addAttribute("usuarios", new Usuario());
		return "usuarios/formCategoria";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") int idCategoria,RedirectAttributes atributo) {
		serviceUsuarios.eliminar(idCategoria);
		atributo.addFlashAttribute("msg","Categoria eliminada");
		return "redirect:/usuarios/index";
	}
	
}
