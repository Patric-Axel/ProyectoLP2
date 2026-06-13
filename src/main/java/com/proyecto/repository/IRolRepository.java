package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyecto.model.Rol;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {

}
