package com.proyecto.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.servicio.ReporteProductoServicio;
import com.proyecto.servicio.ReporteVentasServicio;

@Controller
public class ReporteProductoController {
	
private final ReporteProductoServicio repProdServicio;
	
	public ReporteProductoController(ReporteProductoServicio repProdServicio) {
		this.repProdServicio = repProdServicio;
	}
	@GetMapping("/reporteproductos/pdf")
	public ResponseEntity<byte[]> verReportePDF(){
		byte[] pdf = repProdServicio.generarReporte();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=reporte.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(pdf);
	}
	@GetMapping("/reporteproductos")
	public String vistaReporte() {
		return "reportes/reporteventas";
	}
}
