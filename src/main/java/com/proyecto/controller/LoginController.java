package com.proyecto.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.model.Usuario;
import com.proyecto.repository.IUsuarioRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	//LOGIN Y REGISTRO EN UN MISMO HTML
	//LOGIN
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@GetMapping("/login")
	public String login(Model model) {

		model.addAttribute("usuarioLogin", new Usuario());
		model.addAttribute("usuarioRegistro", new Usuario());
		

		return "auth/login";
	}

	@PostMapping("/login")
	public String validarLogin(
	        @ModelAttribute("usuarioLogin") Usuario usuario,
	        Model model,
	        HttpSession session) {

	    Usuario usuarioBD = usuarioRepository
	            .findByCorreoAndContrasena(
	                    usuario.getCorreo(),
	                    usuario.getContrasena());

	    if (usuarioBD == null) {

	        model.addAttribute(
	                "mensajeError",
	                "Correo o contraseña incorrectos");
	        model.addAttribute("usuarioLogin", new Usuario());
	        model.addAttribute("usuarioRegistro", new Usuario());

	        return "auth/login";
	    }

	    session.setAttribute("usuarioLogueado", usuarioBD);

	    if (usuarioBD.getId_rol() == 1) {
	        return "redirect:/home/index";
	    }

	    return "redirect:/home/index";
	}
	
	//REGISTRO ----------------------------------------------------
	@PostMapping("/registro")
	public String registrar(
	        @ModelAttribute("usuarioRegistro") Usuario usuario,
	        RedirectAttributes flash) {

	    Usuario existe =
	            usuarioRepository.findByCorreo(usuario.getCorreo());

	    if(existe != null) {

	        flash.addFlashAttribute(
	                "mensajeErrorRegistro",
	                "El correo ya existe");

	        return "redirect:/login";
	    }

	    usuario.setId_rol(2);
	    usuario.setIdestado(1);
	    usuario.setFechaRegistro(LocalDateTime.now());

	    usuarioRepository.save(usuario);

	    flash.addFlashAttribute(
	            "mensaje",
	            "Cuenta creada correctamente");

	    return "redirect:/login";
	}
	
	//CERRAR SESION --------------------------------------------------
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {

	    session.invalidate();

	    return "redirect:/login";
	}
	
	

}
