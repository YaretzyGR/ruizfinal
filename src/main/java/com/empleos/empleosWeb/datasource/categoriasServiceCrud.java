package com.empleos.empleosWeb.datasource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.empleos.empleosWeb.model.Categoria;
import com.empleos.empleosWeb.repository.CategoriasRepository;
import com.empleos.empleosWeb.service.IntCategoriasService;

@Service
@Primary
public class categoriasServiceCrud implements IntCategoriasService {

	@Autowired
	private CategoriasRepository repoCategorias;
	
	
	@Override
	public List<Categoria> obtenerTodas() {
		// TODO Auto-generated method stub
		return (List<Categoria>) repoCategorias.findAll();
	}

	@Override
	public void eliminar(Integer idCategoria) {
		repoCategorias.deleteById(idCategoria);

	}

	@Override
	public void guardar(Categoria categoria) {
		repoCategorias.save(categoria);
		// TODO Auto-generated method stub

	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		return repoCategorias.findById(idCategoria).get();
	}


	@Override
	public int buscarPosicion(Categoria categoria) {
		int index = 0; Categoria aux = null;
		int posicion = -1;
		while(index < repoCategorias.count()) {
			aux = repoCategorias.findById(index).get();
			if(aux.getId()==categoria.getId()) {
				posicion= index;
				break;
		} index++;
		
	} return posicion;
	}

}
