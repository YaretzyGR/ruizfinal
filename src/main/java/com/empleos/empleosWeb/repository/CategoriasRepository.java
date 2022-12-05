package com.empleos.empleosWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empleos.empleosWeb.model.Categoria;

@Repository
public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
	
}
