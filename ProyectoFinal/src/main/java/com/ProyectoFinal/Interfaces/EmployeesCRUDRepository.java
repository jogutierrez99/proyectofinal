package com.ProyectoFinal.Interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ProyectoFinal.Entities.Employee;
import com.ProyectoFinal.Entities.Log;

public interface EmployeesCRUDRepository extends CrudRepository<Employee, Integer>{

	// Crear una API Rest propia

		// @Query(value = "SELECT * from Logs where year=:anio and month=:mes",
		// nativeQuery = true)

		// En el leguaje JPAQL el Log es el objeto
		@Query("from Log a where a.month=:mes and a.year=:anio")
		public Iterable<Log> getAccessByAnioAndMes(int anio, int mes);

		@Query("from Log a where a.month=:mes and a.year=:anio and a.employee.nombre=:nombre")
		public Iterable<Log> getAccessByAnioAndMesAndName(int anio, int mes, String nombre);

		@Query("from Log a where a.month=:mes and a.year>=:anioOrigen and a.year<=:anioFinal and a.employee.nombre=:nombre")
		public Iterable<Log> getAccessByAnioAndMesAndName(int anioOrigen, int anioFinal, int mes, String nombre);
	
}
