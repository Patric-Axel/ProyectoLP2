package com.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="estado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estado {
	
	@Id
	private Integer idestado;
	private String descripcion;

}
