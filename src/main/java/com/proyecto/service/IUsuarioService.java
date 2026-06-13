package com.proyecto.service;

import com.proyecto.model.Usuario;

public interface IUsuarioService {
	Usuario validarLogin(String correo, String contrasena);
}
