package com.proyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_proveedor;
	private String nom_proveedor;
	private String razon_social;
	private String ruc;
	private String telefono;
	private String correo;
	private String direccion;
	private Integer idestado; //se corrigio el boolean
	
	@ManyToOne //muchos a uno
	@JoinColumn(insertable = false, updatable = false, name = "idestado") // para decirle al objeto tipo que solo es de consulta no lo creara
	private Estado objEstadopro;
	


}
