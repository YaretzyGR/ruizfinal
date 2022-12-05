package com.empleos.empleosWeb.service;

import java.util.List;

import com.empleos.empleosWeb.model.Usuario;

public interface IntUsuariosService {
	
	public List<Usuario> obtenerTodas();
	public void agregar(Usuario usuario);
	public Usuario buscarPorId(int idUsuario);
	public void eliminar(int idUsuario);

}
