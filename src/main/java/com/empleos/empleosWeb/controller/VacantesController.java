package com.empleos.empleosWeb.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.util.http.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empleos.empleosWeb.model.Categoria;
import com.empleos.empleosWeb.model.Vacante;
import com.empleos.empleosWeb.service.IntCategoriasService;
import com.empleos.empleosWeb.service.IntVacantesService;
import com.empleos.empleosWeb.service.VacantesService;
import com.empleos.empleosWeb.util.Utileria;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {
	
	@Autowired
	private IntVacantesService vacantesService;
	@Autowired
	private IntCategoriasService categoriasService;
	
	@PostMapping("/guardar")
	public String guardar(@Valid Vacante vacante,BindingResult br, RedirectAttributes atributo,@RequestParam("archivoImagen") MultipartFile multiPart,Model model) {
		if(br.hasErrors()) {
			for(ObjectError error: br.getAllErrors()) {
				System.out.print("Error :" + error.getDefaultMessage());
				
			}
			model.addAttribute("categorias", categoriasService.obtenerTodas()); 
			return "vacantes/formVacante";
		}else {
			if(vacante.getId()== null) {
				System.out.print(vacante);
				vacante.setId(vacantesService.obtenerTodas().size()+1);
				System.out.print(vacante);
				vacantesService.agregar(vacante);
				if (!multiPart.isEmpty()) {
					//String ruta = "/empleos/img-vacantes/"; // Linux/MAC
					String ruta = "c:/empleos/img-vacantes/"; // Windows
					String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
					if (nombreImagen != null){ // La imagen si se subio
					// Procesamos la variable nombreImagen
					vacante.setImagen(nombreImagen);
					}
					}
			}
		}
		atributo.addFlashAttribute("msg","Vacante Registrado");
		return "redirect:/vacantes/index";
	}
	
	@GetMapping("/detalle")
	public String detalle(@RequestParam("id") int idVacante, Model model) {
		
		Vacante vacante =vacantesService.buscarPorId(idVacante);
		model.addAttribute("vacante", vacante);
		return "vacantes/detalle";
	}
	
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Vacante> lista = vacantesService.obtenerTodas();
		for(Vacante v : lista) {
			System.out.println(v);
		}
		model.addAttribute("vacantes",lista);
		return "vacantes/listVacantes";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") int idVacante,RedirectAttributes atributo) {
		vacantesService.eliminar(idVacante);
		atributo.addFlashAttribute("msg","Vacante eliminada");
		return "redirect:/vacantes/index";
	}
	
	@GetMapping("/crear")
	public String crearCategoria(Vacante vacante, Model model) {
		model.addAttribute("categorias", categoriasService.obtenerTodas());
		return "vacantes/formVacante";
	}
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int ids, Model model) {
		Vacante vacante = vacantesService.buscarPorId(ids);
		model.addAttribute("vacante", vacante);
		model.addAttribute("categorias", categoriasService.obtenerTodas());
		return "vacantes/formVacante";
	}
	
	
}
