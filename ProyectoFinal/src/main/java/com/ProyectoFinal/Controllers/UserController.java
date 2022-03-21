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

	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	/*@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
            HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("usuario");
		
		//User usuario = userRepo.getLogin(user, password);
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		
		/*if((userRepo.getLogin(username, password)==null)) {
			System.out.println("no hay usuario");
		}else {
			System.out.println("si hay usuario");
		}
		
		List<User> lista = userRepo.findAll();

		modelAndView.addObject("miObjetoNombre", lista.get(0).getUser());
		//modelAndView.addObject("miObjetoNombre", usu.getId());
		modelAndView.addObject("ahora", new Timestamp(new java.util.Date().getTime()));
		modelAndView.addObject("lista", lista);
		modelAndView.addObject("username", username);
		modelAndView.addObject("password", password);
		return modelAndView;

	}*/
	
	@RequestMapping("/login")
	public ModelAndView login(@RequestParam(value="username") String user, 
			@RequestParam(value="password") String password) {

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("usuario");
		
		List<User> lista = userRepo.findAll();
		
		String mensaje = "";
		
		/*for (int i = 0; i < lista.size(); i++) {
			
			if((lista.get(i).getUser()==user) && (lista.get(i).getPassword()==password)) {
				mensaje = "usuario encontrado";
			}else {
				mensaje = " Usuario malo";
			}
			
		}*/
		
		
		for (User usuario : lista) {
			
			if(usuario.getUser().equalsIgnoreCase(user) && usuario.getPassword().equalsIgnoreCase(password)) {
				mensaje = "usuario encontrado";
				break;
			}else {
				mensaje = " Usuario malo";
			}
		}

		modelAndView.addObject("username", user);
		modelAndView.addObject("password", password);
		
		modelAndView.addObject("mensaje", mensaje);
		
		return modelAndView;

	}
	
	
	
	
	
	
}
