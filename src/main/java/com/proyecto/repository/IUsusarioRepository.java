package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Usuario;

@Repository
public interface IUsusarioRepository extends JpaRepository<Usuario, Integer>{
	Usuario findByNombreAndContrasena(String nombre, String contrasena);
}
