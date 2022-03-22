package com.ProyectoFinal.Controllers;

import java.util.List;
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

	@GetMapping("/listarUno/{id}")
	public Optional<User> listarUno(@PathVariable("id") Integer id) {
		return userRepo.findById(id);
	}

	//add usuario
	@RequestMapping("/add")
	public ModelAndView addUser(@RequestParam(value="roleid") int roleid, @RequestParam(value="user") String user,
			@RequestParam(value="password") String password) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		User nuevoUser = new User();
		
		nuevoUser.setUser(user);
		nuevoUser.setPassword(password);
		
		Role rol = new Role();

		switch (roleid) {

		case 1:

			rol.setId(roleid);
			rol.setRol("admin");

			nuevoUser.setRole(rol);
			nuevoUser.setEnabled(1);

			userRepo.save(nuevoUser);
			break;
		case 2:

			rol.setId(roleid);
			rol.setRol("advance");

			nuevoUser.setRole(rol);
			nuevoUser.setEnabled(1);

			userRepo.save(nuevoUser);
			break;

		case 3:

			rol.setId(roleid);
			rol.setRol("raso");

			nuevoUser.setRole(rol);
			nuevoUser.setEnabled(1);

			userRepo.save(nuevoUser);
			break;

		default:
			String mensaje = "Role id diferente: 1,2 o 3";
			modelAndView.addObject("mensaje", mensaje);
			break;
		}
		
		modelAndView.setViewName("usuarioAdmin");
		
		return modelAndView;
	}

	// delete usuario
	@RequestMapping("/delete")
	public ModelAndView deleteUser(@RequestParam(value="id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("usuarioAdmin");
		userRepo.deleteById(id);
		
		return modelAndView;
	}

	//Update --> falta diferenciar por role.... admin,advance,raso
	@RequestMapping("/updateAdmin")
	public ModelAndView updateUserAdmin(@RequestParam(value = "id") int id, @RequestParam(value = "enabled") int enabled,
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
	
	
	@RequestMapping("/update")
	public ModelAndView updateUser(@RequestParam(value = "id") int id,
			@RequestParam(value = "user") String user, @RequestParam(value = "password") String password) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		User nuevo = new User();
		
		nuevo.setId(id);
		nuevo.setUser(user);
		nuevo.setPassword(password);
		
		List<User> lista = userRepo.findAll();
		
		Role role = new Role();
		
		
		for (User usuario : lista) {
			
			if(usuario.getId()==id) {
				
				role.setId(usuario.getRole().getId());
				role.setRol(usuario.getRole().getRol());
				nuevo.setEnabled(usuario.getEnabled());
				nuevo.setRole(role);
				
			}
			
		}
		
		
		userRepo.save(nuevo);
		
		switch (nuevo.getRole().getId()) {
		case 2:
			modelAndView.setViewName("usuarioAdvance");
			break;
			
		case 3:
			modelAndView.setViewName("usuarioRaso");
			break;

		default:
			break;
		}
		
		
		return modelAndView;
		
		}
	
	
	
	
	
	
	

}
