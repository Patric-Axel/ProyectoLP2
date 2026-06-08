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
@Table(name="producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer cantidad;
	private Integer idestado;
	private Integer id_categoria;
	private Integer id_proveedor;
	
	//generamos los joins
	@ManyToOne //muchos a uno
	@JoinColumn(insertable = false, updatable = false, name = "idestado") // para decirle al objeto tipo que solo es de consulta no lo creara
	private Estado objEstadoProducto;
	
	@ManyToOne //muchos a uno
	@JoinColumn(insertable = false, updatable = false, name = "id_categoria") // para decirle al objeto tipo que solo es de consulta no lo creara
	private Categoria objCategoria;
	
	@ManyToOne //muchos a muchos
	@JoinColumn(insertable = false, updatable = false, name = "id_proveedor") // para decirle al objeto tipo que solo es de consulta no lo creara
	private Proveedor objProveedor;
	
	

}
