package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.service.ProductoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/login")
	public String home(HttpSession session) {

	    if(session.getAttribute("usuarioLogueado") == null) {
	        return "redirect:/login";
	    }

	    return "index";
	}
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("productos", productoService.listarTop6());
		return "index";
	}
	
	
}
