package com.proyecto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.proyecto.model.DetallePedido;
import com.proyecto.model.Pedido;
import com.proyecto.model.Producto;
import com.proyecto.repository.IDetallePedidoRepository;
import com.proyecto.repository.IPedidoRepository;
import com.proyecto.repository.IProductoRepository;

@Controller
public class PedidoController {

    @Autowired
    private IProductoRepository productoRepository;

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Autowired
    private IDetallePedidoRepository detallePedidoRepository;

    private List<Producto> carrito = new ArrayList<>();

    @GetMapping("/carrito/agregar/{id}")
    public String agregarCarrito(@PathVariable Integer id) {
        Producto producto = productoRepository.findById(id).orElse(null);

        if (producto != null) {
            carrito.add(producto);
        }

        return "redirect:/productos";
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        double total = 0;

        for (Producto p : carrito) {
            total += p.getPrecio();
        }

        model.addAttribute("carrito", carrito);
        model.addAttribute("total", total);

        return "carrito";
    }

    @GetMapping("/pedido/confirmar")
    public String confirmarPedido() {

        if (carrito.isEmpty()) {
            return "redirect:/carrito";
        }

        double total = 0;

        for (Producto p : carrito) {
            total += p.getPrecio();
        }

        Pedido pedido = new Pedido();
        pedido.setId_usuario(1);
        pedido.setIdestado_pedido(1);
        pedido.setTotal(total);

        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        for (Producto p : carrito) {
            DetallePedido detalle = new DetallePedido();
            detalle.setId_pedido(pedidoGuardado.getId_pedido());
            detalle.setId_producto(p.getId_producto());
            detalle.setCantidad(1);
            detalle.setPrecio_unitario(p.getPrecio());
            detalle.setSubtotal(p.getPrecio());

            detallePedidoRepository.save(detalle);
        }

        carrito.clear();

        return "redirect:/productos";
    }
}