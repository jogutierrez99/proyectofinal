package com.ProyectoFinal.Interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ProyectoFinal.Entities.Role;


public interface RolesCRUDRepository extends CrudRepository<Role, Integer>{

//	@Query(" from roles as role where role.id=1")
//	public Role getRole1();
//	
//	@Query(" from roles as role where role.id=2")
//	public Iterable<Role> getRole2();
//	
//	@Query(" from roles as role where role.id=3")
//	public Iterable<Role> getRole3();
}
