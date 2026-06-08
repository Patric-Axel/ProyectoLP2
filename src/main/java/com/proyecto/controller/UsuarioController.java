package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.repositorio.IProductoRepository;
import com.proyecto.repositorio.IUsusarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	private IUsusarioRepository repoUsu;

	@GetMapping("/crudusu")
	public String listarUsuarios(Model model) {
		
		model.addAttribute("lstUsuarios", repoUsu.findAll());
		return "crudusuarios";
	}

}
