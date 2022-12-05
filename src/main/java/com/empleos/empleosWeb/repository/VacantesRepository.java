package com.empleos.empleosWeb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empleos.empleosWeb.model.Vacante;

@Repository
public interface VacantesRepository extends CrudRepository<Vacante, Integer> {

}
