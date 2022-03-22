package com.ProyectoFinal.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ProyectoFinal.Entities.Role;
import com.ProyectoFinal.Entities.User;
import com.ProyectoFinal.Interfaces.RolesCRUDRepository;
import com.ProyectoFinal.Interfaces.UsersCRUDRepository;

@RestController
@RequestMapping("/login/usuario")
public class UsuarioRest {

	@Autowired
	private UsersCRUDRepository userRepo;

	@Autowired
	private RolesCRUDRepository rolRepo;

	public UsersCRUDRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UsersCRUDRepository userRepo) {
		this.userRepo = userRepo;
	}

	public RolesCRUDRepository getRolRepo() {
		return rolRepo;
	}

	public void setRolRepo(RolesCRUDRepository rolRepo) {
		this.rolRepo = rolRepo;
	}

	@GetMapping
	public Iterable<User> findAll() {

		return userRepo.findAll();
	}

	@GetMapping("listarUno/{id}")
	public Optional<User> listarUno(@PathVariable("id") Integer id) {
		return userRepo.findById(id);
	}

	// add usuario
	@PostMapping("/add/{roleid}")
	public void addUser(@PathVariable("roleid") Integer roleid, @RequestBody User usu) {

		Role rol = new Role();

		switch (roleid) {

		case 1:

			rol.setId(roleid);
			rol.setRol("admin");

			usu.setRole(rol);
			usu.setEnabled(1);

			userRepo.save(usu);
			break;
		case 2:

			rol.setId(roleid);
			rol.setRol("advance");

			usu.setRole(rol);
			usu.setEnabled(1);

			userRepo.save(usu);
			break;

		case 3:

			rol.setId(roleid);
			rol.setRol("raso");

			usu.setRole(rol);
			usu.setEnabled(1);

			userRepo.save(usu);
			break;

		default:
			System.out.println("id diferente");
			break;
		}
	}

	// delete usuario
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") int id) {

		userRepo.deleteById(id);

	}

	//Update --> falta diferenciar por role.... admin,advance,raso
	@RequestMapping("/update")
	public ModelAndView updateUser(@RequestParam(value = "id") int id, @RequestParam(value = "enabled") int enabled,
			@RequestParam(value = "roleid") int roleid,
			@RequestParam(value = "user") String user, @RequestParam(value = "password") String password) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		User nuevo = new User();
		
		nuevo.setId(id);
		nuevo.setUser(user);
		nuevo.setEnabled(enabled);
		nuevo.setPassword(password);
		
		Role rol = new Role();
		
		switch (roleid) {
		case 1:
			
			rol.setId(roleid);
			rol.setRol("admin");
			
			nuevo.setRole(rol);
			break;
		case 2:

			rol.setId(roleid);
			rol.setRol("advance");
			nuevo.setRole(rol);
			break;
		case 3:

			rol.setId(roleid);
			rol.setRol("raso");
			
			nuevo.setRole(rol);
			break;

		default:
			break;
		}
		
		userRepo.save(nuevo);
		
		modelAndView.setViewName("usuarioAdmin");
		
		return modelAndView;
		
		}
	
	
	
	
	
	
	
	
	

}
