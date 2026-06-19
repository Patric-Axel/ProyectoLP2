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

import com.proyecto.model.Producto;
import com.proyecto.repository.IProductoRepository;
import com.proyecto.service.CategoriaService;
import com.proyecto.service.EstadoService;
import com.proyecto.service.ProductoService;
import com.proyecto.service.ProveedorService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private EstadoService estadoService;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ProveedorService proveedorService;

	@GetMapping("/listar")
	public String listarProductos(Model model) {
		
		model.addAttribute("lstProductos", productoService.listarProductos());
		return "producto/listar";
	}
	 @GetMapping("/editar/{id_producto}")
	    public String editar(Model model, @PathVariable Integer id_producto) {
	    	model.addAttribute("producto", productoService.buscarPorId(id_producto));
	    	model.addAttribute("lstEstados", estadoService.listarEstados());
	    	model.addAttribute("lstCategorias", categoriaService.listarCategorias());
	    	model.addAttribute("lstProveedores", proveedorService.listarProveedores());
	    	return "producto/editar";
	    }
	  @PostMapping("/actualizar")
	    public String actualizar(@ModelAttribute Producto producto, RedirectAttributes ra) {
	    	try {
	    		productoService.actualizar(producto);
				ra.addFlashAttribute("mensaje","Producto actualizado correctamente");
				ra.addFlashAttribute("tipo","success");
			} catch (Exception e) {
				ra.addFlashAttribute("mensaje","Error al actualizar");
				ra.addFlashAttribute("tipo","error");
			}
	    	return "redirect:/producto/listar";
	    }
	  @GetMapping("/registrar")
	  public String registar(Producto producto, Model model) {
		  model.addAttribute("producto", new Producto());
		  model.addAttribute("lstCategorias", categoriaService.listarCategorias());
		  model.addAttribute("lstProveedores", proveedorService.listarProveedores());
		  return "producto/crear";
	  }
	  @PostMapping("/guardar")
	  public String grabar(@ModelAttribute Producto producto, RedirectAttributes ra) {
		  try {
			productoService.registrar(producto);
			ra.addFlashAttribute("mensaje","Producto registrado correctamente");
			ra.addFlashAttribute("tipo","success");
		} catch (Exception e) {
			ra.addFlashAttribute("mensaje","Error al registrar producto");
			ra.addFlashAttribute("tipo","error");
		}
		  return "redirect:/producto/listar";
	  }
	
}

