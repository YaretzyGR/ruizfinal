package com.empleos.empleosWeb.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleos.empleosWeb.model.Categoria;
import com.empleos.empleosWeb.repository.CategoriasRepository;

@Service
public class CategoriasService implements IntCategoriasService {

	public List<Categoria> lista;
	
	@Autowired
	private CategoriasRepository categoriasRepo;
		
	public CategoriasService() {
		lista = new LinkedList<Categoria>();
		
		Categoria c1= new Categoria();
		c1.setId(1);
		c1.setNombre("Recursos Humanos");
		c1.setDescripcion("Relacionado con psicologos,Administradores");
		
		
		Categoria c2= new Categoria();
		c2.setId(2);
		c2.setNombre("Ventas");
		c2.setDescripcion("Relacionado con productos farmaseuticos");
		
		
		Categoria c3= new Categoria();
		c3.setId(3);
		c3.setNombre("Contabilidad");
		c3.setDescripcion("Relacionado con contabilidad y finanzas");
		
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
	}
	
	@Override
	public List<Categoria> obtenerTodas(){
		
		return lista;
	}

		
	
	@Override
	public void eliminar(Integer idCategoria) {
		//lista.remove(buscarPorId(idCategoria));
		categoriasRepo.deleteById(idCategoria);

	}

	@Override
	public void guardar(Categoria categoria) {
		//lista.add(categoria);
		categoriasRepo.save(categoria);
	}
	
	@Override
	public Categoria buscarPorId(Integer idcategoria) {
		for(Categoria cat:lista) {
			if(cat.getId()==idcategoria) {
				return cat;
			}
		}
		return null;
	}

	@Override
	public int buscarPosicion(Categoria categoria) {
		int index = 0; Categoria aux = null;
		int posicion = -1;
		while(index < lista.size()) {
			aux = lista.get(index);
			if(aux.getId()==categoria.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
	}


}
