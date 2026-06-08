package com.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

}
