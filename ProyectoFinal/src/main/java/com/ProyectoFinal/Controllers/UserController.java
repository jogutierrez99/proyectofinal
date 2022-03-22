package com.ProyectoFinal.Controllers;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ProyectoFinal.Entities.User;
import com.ProyectoFinal.Interfaces.UsersCRUDRepository;

@Controller
public class UserController {

	@Autowired
	private UsersCRUDRepository userRepo;

	public UsersCRUDRepository getUserRepo() {
		return userRepo;
	}

	public void setUserRepo(UsersCRUDRepository userRepo) {
		this.userRepo = userRepo;
	}

	@GetMapping("/login")
	public String index() {

		return "login";
	}

	@RequestMapping("/login/usuario")
	public ModelAndView login(@RequestParam(value = "username") String user,
			@RequestParam(value = "password") String password) {

		ModelAndView modelAndView = new ModelAndView();
	
		List<User> lista = userRepo.findAll();

		String mensaje = "";

		for (User usuario : lista) {

			if (usuario.getUser().equalsIgnoreCase(user) && usuario.getPassword().equalsIgnoreCase(password)) {
				modelAndView.addObject("tipoUsuario", usuario.getRole().getRol());

				mensaje = "usuario encontrado";

				switch (usuario.getRole().getId()) {
				case 1:
					modelAndView.setViewName("usuarioAdmin");
					return modelAndView;
				case 2:					
					modelAndView.setViewName("usuarioAdvance");
					return modelAndView;
				case 3:
					modelAndView.setViewName("usuarioRaso");
					return modelAndView;

				default:
					break;
				}

				break;
			} else {
				mensaje = " Usuario o contraseña incorrectas";
			}
		}

		modelAndView.addObject("username", user);
		modelAndView.addObject("password", password);

		modelAndView.addObject("mensaje", mensaje);

		modelAndView.setViewName("login");
		
		return modelAndView;

	}

}
