package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.model.Usuario;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	

	    @GetMapping("/perfil")
	    public String perfil(HttpSession session, Model model) {

	        Usuario usuario =
	            (Usuario) session.getAttribute("usuarioLogueado");

	        model.addAttribute("usuario", usuario);

	        return "usuario/perfil";
	    }
	
}
