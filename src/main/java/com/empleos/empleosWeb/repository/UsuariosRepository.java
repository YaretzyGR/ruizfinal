package com.empleos.empleosWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empleos.empleosWeb.model.Usuario;

@Repository
public interface UsuariosRepository extends CrudRepository<Usuario, Integer> {

}
