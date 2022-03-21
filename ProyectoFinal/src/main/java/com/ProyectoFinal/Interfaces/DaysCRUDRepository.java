package com.ProyectoFinal.Interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ProyectoFinal.Entities.Day;

@Repository
public interface DaysCRUDRepository extends CrudRepository<Day, Integer>{

	@Query("from Day as d  where d.especial=:dato")
	public Iterable<Day> getJornadasConUno(boolean dato);
}
