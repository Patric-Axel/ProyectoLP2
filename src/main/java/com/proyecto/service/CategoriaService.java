package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Categoria;
import com.proyecto.repository.ICategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{
	@Autowired
	private ICategoriaRepository categoriaRepository;
	@Override
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

}
