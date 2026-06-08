package com.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.model.Estado;

@Repository
public interface IEstadoRepository extends JpaRepository<Estado, Integer>{

}
