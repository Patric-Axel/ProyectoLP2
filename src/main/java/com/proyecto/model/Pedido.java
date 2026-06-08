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
@Table(name = "pedido")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;
	private String fec_pedido;
	private Integer id_usuario;
	private Integer idestado_pedido;
	private Double total;
	
	@ManyToOne //muchos a uno
	@JoinColumn(insertable = false, updatable = false, name = "id_usuario") // para decirle al objeto tipo que solo es de consulta no lo creara
	private Usuario objUsuario;
	
	@ManyToOne //muchos a uno
	@JoinColumn(insertable = false, updatable = false, name = "idestado_pedido") // para decirle al objeto tipo que solo es de consulta no lo creara
	private EstadoPedido objEstado_pedido;
}
