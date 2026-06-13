package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.EstadoPedido;

@Repository
public interface IEstadoPedidoRepository extends JpaRepository<EstadoPedido, Integer>{

}
