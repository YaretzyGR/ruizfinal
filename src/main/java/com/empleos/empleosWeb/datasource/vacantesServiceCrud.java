package com.empleos.empleosWeb.datasource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.empleos.empleosWeb.model.Vacante;
import com.empleos.empleosWeb.repository.VacantesRepository;
import com.empleos.empleosWeb.service.IntVacantesService;

@Service
@Primary
public class vacantesServiceCrud implements IntVacantesService {

	@Autowired
	private VacantesRepository repoVacantes;
	
	@Override
	public List<Vacante> obtenerTodas() {
		// TODO Auto-generated method stub
		return (List<Vacante>) repoVacantes.findAll();
	}

	@Override
	public void agregar(Vacante vacante) {
		repoVacantes.save(vacante);

	}

	@Override
	public void eliminar(int idVacante) {
		repoVacantes.deleteById(idVacante);

	}

	@Override
	public Vacante buscarPorId(int idVacante) {
		// TODO Auto-generated method stub
		return repoVacantes.findById(idVacante).get();
	}

	@Override
	public void modificar(Integer posicion, Vacante vacante) {
		// TODO Auto-generated method stub

	}

}
