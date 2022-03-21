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
import org.springframework.web.bind.annotation.RestController;

import com.ProyectoFinal.Entities.Role;
import com.ProyectoFinal.Entities.User;
import com.ProyectoFinal.Interfaces.RolesCRUDRepository;
import com.ProyectoFinal.Interfaces.UsersCRUDRepository;




@RestController
@RequestMapping("/usuario")
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

	//add usuario
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

	//metodo antiguo para put
	/*
	@PutMapping("/update/{id}/{user}/{password}/{roleid}/{enabled}")
	public void updateUser(@PathVariable("id") int id, @PathVariable("user") String nameUser,
			@PathVariable("password") String password, @PathVariable("roleid") int roleid,
			@PathVariable("enabled") int enabled , @RequestBody User usuario) {

		
		switch (roleid) {

		case 1:

			User usu = new User();

			usu.setId(id);
			usu.setUser(nameUser);
			usu.setPassword(password);

			Role rol = new Role();

			switch (roleid) {
			case 1:

				rol.setId(roleid);
				rol.setRol("admin");
				usu.setRole(rol);

				break;

			case 2:

				rol.setId(roleid);
				rol.setRol("advance");
				usu.setRole(rol);

				break;
			case 3:

				rol.setId(roleid);
				rol.setRol("raso");
				usu.setRole(rol);

				break;

			default:
				break;
			}

			usu.setEnabled(enabled);

			userRepo.save(usu);
			break;

		default:
			System.out.println("No tienes nivel para actualizar");
			break;

		}
		
	} */
	
	//delete usuario
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		
		userRepo.deleteById(id);	
		
	}
	
	//update de prueba
	/* 
	@PutMapping("/actualizarUsuario/{id}")
	public void actualizarId(@RequestBody User usu, @PathVariable("id") Integer buscoId) {
	Iterable<User> lista= getUserRepo().findAll();
	for (User usua:lista) {
	if(usua.getId()==buscoId)
	userRepo.save(usu);
	}
	}*/
	
	
	
	
	//update usuario
	@PutMapping("/update/{id}/{roleid}")
	public void actualizarUser(@PathVariable("id") int id, @PathVariable("roleid") int roleid , @RequestBody User usuario) {

		
		switch (roleid) {

		case 1:

			usuario.setId(id);
			usuario.setUser(usuario.getUser());
			usuario.setPassword(usuario.getPassword());

			Role rol = new Role();

			switch (usuario.getRole().getId()) {
			case 1:

				rol.setId(usuario.getRole().getId());
				rol.setRol("admin");
				usuario.setRole(rol);

				break;

			case 2:

				rol.setId(usuario.getRole().getId());
				rol.setRol("advance");
				usuario.setRole(rol);

				break;
			case 3:

				rol.setId(usuario.getRole().getId());
				rol.setRol("raso");
				usuario.setRole(rol);

				break;

			default:
				break;
			}

			usuario.setEnabled(usuario.getEnabled());

			userRepo.save(usuario);
			break;

		default:
			System.out.println("No tienes nivel para actualizar");
			break;

		}
		
	}
	
	
	
	
	
	
	
	
	

}
