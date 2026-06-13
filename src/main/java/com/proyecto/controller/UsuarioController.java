package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.model.Usuario;
import com.proyecto.repository.IProductoRepository;
import com.proyecto.repository.IUsusarioRepository;
import com.proyecto.service.IUsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {
	@Autowired
	private IUsuarioService servicio;

	@PostMapping("/login")
	public String login(@RequestParam String usuario,
						@RequestParam String password,
						HttpSession session,
						Model model) {
		
		Usuario u = servicio.validarLogin(usuario, password);
		
		if (u != null) {
			session.setAttribute("usuario", u);
			return "redirect:/home";
		}
		model.addAttribute("error", "Credenciales incorrectas");
		return "login";
	
	}

}
