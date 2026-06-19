package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Estado;
import com.proyecto.repository.IEstadoRepository;
@Service
public class EstadoService implements IEstadoService{
	@Autowired
	private IEstadoRepository repo;
	@Override
	public List<Estado> listarEstados() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
