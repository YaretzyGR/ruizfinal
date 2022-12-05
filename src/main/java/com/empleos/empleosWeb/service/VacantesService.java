package com.empleos.empleosWeb.service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleos.empleosWeb.model.Categoria;
import com.empleos.empleosWeb.model.Vacante;
import com.empleos.empleosWeb.repository.VacantesRepository;

@Service
public class VacantesService implements IntVacantesService {
	
	public List<Vacante> lista;
	
	@Autowired
	private VacantesRepository repoVacantes;
	
	
    public VacantesService() {
    	/*lista=new LinkedList<Vacante>();
    	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	
    	try {
    		Vacante v1=new Vacante();
    		v1.setId(1);
    		v1.setNombre("Programador web");
    		v1.setDescripcion("Desarrollo de aplicaciones web responsivas");
    		v1.setFecha(LocalDate.parse("19-09-2022",formato));
    		v1.setSalario(12000.0);
    		v1.setEstatus("Creada");
    		v1.setDestacado(1);
    		v1.setDetalles("<h1>Requisitos</h1><ul><li>Amplia Experiencia</li></ul>");
    		v1.setImagen("logo1.png");
    		Categoria cat1 = new Categoria();
    		cat1.setId(4);
    		v1.setCategoria(cat1);
    		
    		Vacante v2=new Vacante();
    		v2.setId(2);
    		v2.setNombre("Contador Publico");
    		v2.setDescripcion("Contabilidad y Finanzas");
    		v2.setFecha(LocalDate.parse("18-09-2022",formato));
    		v2.setSalario(10000.0);
    		v2.setEstatus("Creada");
    		v2.setDestacado(2);
    		v2.setDetalles("<h1>Requisitos</h1><ul><li>Ingeniero en sistemas</li></ul>");
    		v2.setImagen("logo1.png");
    		Categoria cat2 = new Categoria();
    		cat2.setId(4);
    		v2.setCategoria(cat2);
    		
    		Vacante v3=new Vacante();
    		v3.setId(3);
    		v3.setNombre("Ingeniero informatico");
    		v3.setDescripcion("Mantenimiento de redes");
    		v3.setFecha(LocalDate.parse("17-09-2022",formato));
    		v3.setSalario(8000.0);
    		v3.setEstatus("Creada");
    		v3.setDestacado(1);
    		v3.setDetalles("<h1>Requisitos</h1><ul><li>De preferencia femenino</li></ul>");
    		v3.setImagen("logo1.png");
    		Categoria cat3 = new Categoria();
    		cat3.setId(5);
    		v3.setCategoria(cat3);
    		
    		lista.add(v1);
    		lista.add(v2);
    		lista.add(v3);
    	}catch(DateTimeException ex) {
    		System.out.print(ex.getMessage());
    		
    	}*/
    	
    }
	
	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return (List<Vacante>) repoVacantes.findAll();
	}

	@Override
	public void agregar(Vacante vacante) {
		//lista.add(vacante);
		repoVacantes.save(vacante);
	}

	@Override
	public void eliminar(int idVacante) {
		//lista.remove(buscarPorId(idVacante));
		repoVacantes.deleteById(idVacante);
	}

	@Override
	public Vacante buscarPorId(int idVacante) {
		return repoVacantes.findById(idVacante).get();
	}

	@Override
	public void modificar(Integer posicion, Vacante vacante) {
		//lista.set(posicion, vacante);
		
	}
	
	
	

}
