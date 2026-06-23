package com.proyecto.service;

import java.util.List;

import com.proyecto.model.Usuario;

public interface IUsuarioService {
	Usuario validarLogin(String correo, String contrasena);
	List<Usuario> listarUsuarios();
	Usuario buscarPorId(Integer id);
	public void actualizar(Usuario usuario);
	void registrar(Usuario usuario);
}
