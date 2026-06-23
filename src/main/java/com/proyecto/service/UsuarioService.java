package com.proyecto.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.model.Usuario;
import com.proyecto.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository repo;
	
	@Override
	public Usuario validarLogin(String nombre, String contrasena) {
		// TODO Auto-generated method stub
		return repo.findByCorreoAndContrasena(nombre, contrasena);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Usuario buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void actualizar(Usuario usuario) {
		repo.save(usuario);
		
	}

	@Override
	public void registrar(Usuario usuario) {
		usuario.setFechaRegistro(LocalDateTime.now());
		usuario.setIdestado(1);
		repo.save(usuario);
	}
	
}
