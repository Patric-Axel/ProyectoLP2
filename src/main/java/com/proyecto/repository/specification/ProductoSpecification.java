package com.proyecto.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import com.proyecto.model.Producto;

public class ProductoSpecification {
	public static Specification<Producto> nombreContiene(String nombre) {
        return (root, query, cb) -> {
            if (nombre == null || nombre.isEmpty()) {
                return cb.conjunction();
            }
            return cb.like(
                cb.lower(root.get("nombre")),
                "%" + nombre.toLowerCase() + "%"
            );
        };
    }

    public static Specification<Producto> porCategoria(Integer categoriaId) {
        return (root, query, cb) -> {
            if (categoriaId == null) {
                return cb.conjunction();
            }
            return cb.equal(
            		root.get("id_categoria"),
            		categoriaId
            		);
        };
    }
}
