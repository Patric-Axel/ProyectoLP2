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
@Table(name = "usuario") //nombre de la tabla se tiene que vincular a la BD porque ya existe
@Data //generamos todos los constructores con y sin parametro
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	private String nombre;
	private String correo;
	private String contrasena;
	private Integer id_rol;
	private Integer	idestado;
	private String fecha_registro;
	
	@ManyToOne //muchos a uno
	@JoinColumn(insertable = false, updatable = false, name = "id_rol") // para decirle al objeto tipo que solo es de consulta no lo creara
	private Rol objRol;
	
	@ManyToOne //muchos a uno
	@JoinColumn(insertable = false, updatable = false, name = "idestado") // para decirle al objeto tipo que solo es de consulta no lo creara
	private Estado objEstado;
	
}
