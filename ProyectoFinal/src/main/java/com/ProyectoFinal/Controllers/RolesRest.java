package com.ProyectoFinal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinal.Entities.Role;
import com.ProyectoFinal.Interfaces.RolesCRUDRepository;



@RestController
@RequestMapping("/roles")
public class RolesRest {
	
	@Autowired
	private RolesCRUDRepository rolesRepo;

	public RolesCRUDRepository getRolesRepo() {
		return rolesRepo;
	}

	public void setRolesRepo(RolesCRUDRepository rolesRepo) {
		this.rolesRepo = rolesRepo;
	}

	@GetMapping
	public Iterable<Role> findAll() {

		return rolesRepo.findAll();
	}

	

}
