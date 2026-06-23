package com.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.model.Usuario;
import com.proyecto.repository.IEstadoRepository;
import com.proyecto.repository.IRolRepository;
import com.proyecto.repository.IUsuarioRepository;
import com.proyecto.service.EstadoService;
import com.proyecto.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
		
		@Autowired
		private UsuarioService usuarioService;
		@Autowired
		private  EstadoService estadoService;
		@Autowired
		private IRolRepository rolRepository;
		@Autowired
		private IEstadoRepository estadoRepository;
	    @GetMapping("/perfil")
	    public String perfil(HttpSession session, Model model) {

	        Usuario usuario =
	            (Usuario) session.getAttribute("usuarioLogueado");

	        model.addAttribute("usuario", usuario);

	        return "usuario/perfil";
	    }
	    @GetMapping("/listar")
	    public String listar(Model model) {
	    	model.addAttribute("lstUsuarios", usuarioService.listarUsuarios());
	    	return "usuario/listar";
	    }
	    @GetMapping("/editar/{id_usuario}")
	    public String editar(Model model, @PathVariable Integer id_usuario) {
	    	model.addAttribute("usuario", usuarioService.buscarPorId(id_usuario));
	    	model.addAttribute("lstEstados", estadoService.listarEstados());
	    	return "usuario/editar";
	    }
	    @PostMapping("/actualizar")
	    public String actualizar(@ModelAttribute Usuario usuario, RedirectAttributes ra) {
	    	try {
	    		usuarioService.actualizar(usuario);
				ra.addFlashAttribute("mensaje","Usuario actualizado correctamente");
				ra.addFlashAttribute("tipo","success");
			} catch (Exception e) {
				ra.addFlashAttribute("mensaje","Error al actualizar");
				ra.addFlashAttribute("tipo","error");
			}
	    	return "redirect:/usuario/listar";
	    }
	    @GetMapping("/nuevo")
	    public String nuevo(Model model) {
	    	model.addAttribute("usuario", new Usuario());
	    	model.addAttribute("lstRoles", rolRepository.findAll());
	    	model.addAttribute("lstEstados", estadoRepository.findAll());
	    	return "usuario/crear";
	    }
	    @PostMapping("/guardar")
	    public String guardar(@ModelAttribute Usuario usuario,
	    		RedirectAttributes ra) {
	    	try {
	    		usuarioService.registrar(usuario);
	    		ra.addFlashAttribute("mensaje","Usuario registrado correctamente");
				ra.addFlashAttribute("tipo","success");
			} catch (Exception e) {
				ra.addFlashAttribute("mensaje","Error al registrar usuario");
				ra.addFlashAttribute("tipo","error");
			}
	    	
	    	return "redirect:/usuario/listar";
	    }
	
}
