package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Estado;
import com.proyecto.model.Producto;
import com.proyecto.repository.IEstadoRepository;
import com.proyecto.repository.IProductoRepository;
@Service
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private IEstadoRepository estadoRepository;
	@Override
	public Producto buscarPorId(Integer id) {
		return productoRepository.findById(id).orElse(null) ;
	}
	@Override
	public List<Estado> listarEstados() {
		
		return estadoRepository.findAll();
	}
	@Override
	public void actualizar(Producto producto) {
		productoRepository.save(producto);
		
	}
	@Override
	public void registrar(Producto producto) {
		producto.setIdestado(1);
		System.out.println("Estado: " + producto.getIdestado());
		productoRepository.save(producto);
	}
	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

}
