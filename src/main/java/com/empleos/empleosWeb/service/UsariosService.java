package com.empleos.empleosWeb.service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleos.empleosWeb.model.Usuario;
import com.empleos.empleosWeb.repository.UsuariosRepository;

@Service
public class UsariosService implements IntUsuariosService {

	public List<Usuario> lista;
	
	@Autowired
	private UsuariosRepository usuariosRepo;
	
	public UsariosService() {
		lista = new LinkedList<Usuario>();
		
		Usuario u1 = new Usuario();
		u1.setId(1);
		u1.setNombre("mail");
		u1.setEmail("mail@gmail.com");
		u1.setUsername("mail");
		u1.setPassword("12345");
		u1.setEstatus(1);
		u1.getFechaRegistro();
		
		lista.add(u1);
		
	}
	
	@Override
	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void agregar(Usuario usuario) {
		usuariosRepo.save(usuario);

	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		// TODO Auto-generated method stub
		return usuariosRepo.findById(idUsuario).get();
	}

	@Override
	public void eliminar(int idUsuario) {
		usuariosRepo.deleteById(idUsuario);

	}

}
