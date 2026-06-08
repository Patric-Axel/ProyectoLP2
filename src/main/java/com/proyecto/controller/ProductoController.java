package com.proyecto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.proyecto.repositorio.IProductoRepository;

@Controller
public class ProductoController {
	@Autowired
	private IProductoRepository productoRepository;

	@GetMapping("/crud")
	public String listarProductos(Model model) {
		
		model.addAttribute("lstProductos", productoRepository.findAll());
		return "crudproductos";
	}
	
	
}
