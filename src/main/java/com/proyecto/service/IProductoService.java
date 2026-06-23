package com.proyecto.service;

import java.util.List;

import com.proyecto.model.Estado;
import com.proyecto.model.Producto;

public interface IProductoService {
	/* Método para el listado de productos*/
	/* Método para listar solo 6 productos en el index*/
	 List<Producto> listarTop6();
	List<Producto> listarProductos();
	/* Método para buscar por ID del producto y editarlo*/
	Producto buscarPorId (Integer id);
	/* Método para enviar el listado de estados a la vista*/
	List<Estado> listarEstados();
	public void actualizar(Producto producto);
	void registrar(Producto producto);
}
