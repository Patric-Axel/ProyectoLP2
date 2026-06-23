package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Proveedor;
import com.proyecto.repository.IProveedorRepository;

@Service
public class ProveedorService implements IProveedorService{
	@Autowired
	private IProveedorRepository proveedorRepository;
	@Override
	public List<Proveedor> listarProveedores() {
		// TODO Auto-generated method stub
		return proveedorRepository.findAll() ;
	}
	
}
