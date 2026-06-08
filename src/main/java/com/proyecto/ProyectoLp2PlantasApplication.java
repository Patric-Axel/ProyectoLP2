package com.proyecto;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class ProyectoLp2PlantasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoLp2PlantasApplication.class, args);
		
		
	}
	

}
