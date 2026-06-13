package com.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Usuario;
import com.proyecto.repository.IUsusarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsusarioRepository repo;
	
	@Override
	public Usuario validarLogin(String nombre, String contrasena) {
		// TODO Auto-generated method stub
		return repo.findByNombreAndContrasena(nombre, contrasena);
	}
	
}
