package com.proyecto.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.proyecto.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>,
		JpaSpecificationExecutor<Producto>{
	@Query(value = "SELECT * FROM producto LIMIT 6", nativeQuery = true)
	List<Producto> listarTop6();
}
