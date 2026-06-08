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
@Table(name ="detalle_pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_detalle;
	private Integer id_pedido;
	private Integer id_producto;
	private Integer cantidad;
	private Double precio_unitario;
	private Double subtotal;
	
	//generamos los joins
		
		@ManyToOne //muchos a uno
		@JoinColumn(insertable = false, updatable = false, name = "id_producto") // para decirle al objeto tipo que solo es de consulta no lo creara
		private Producto objProductopedido;
		

}
