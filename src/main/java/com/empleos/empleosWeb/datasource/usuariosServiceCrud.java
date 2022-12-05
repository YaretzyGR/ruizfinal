package com.empleos.empleosWeb.datasource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.empleos.empleosWeb.model.Usuario;
import com.empleos.empleosWeb.repository.UsuariosRepository;
import com.empleos.empleosWeb.service.IntUsuariosService;

@Service
@Primary
public class usuariosServiceCrud implements IntUsuariosService {
	
	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Override
	public List<Usuario> obtenerTodas() {
		return (List<Usuario>) repoUsuarios.findAll();
	}

	@Override
	public void agregar(Usuario usuario) {
		repoUsuarios.save(usuario);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		return repoUsuarios.findById(idUsuario).get();
	}

	@Override
	public void eliminar(int idUsuario) {
		repoUsuarios.deleteById(idUsuario);

	}

}
