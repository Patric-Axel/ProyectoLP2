package com.proyecto.service;

import com.proyecto.model.Usuario;

public interface IUsuarioService {
	Usuario validarLogin(String nombre, String contrasena);
}
