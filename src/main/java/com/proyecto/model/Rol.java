package com.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
	
	@Id
	private Integer id_rol;
	private String nombre;
}
