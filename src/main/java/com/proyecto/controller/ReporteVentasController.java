package com.proyecto.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.service.ReporteVentasServicio;

@Controller

public class ReporteVentasController {
	
	private final ReporteVentasServicio repVentasServicios;
	
	public ReporteVentasController(ReporteVentasServicio repVentasService) {
		this.repVentasServicios = repVentasService;
	}
	@GetMapping("/reporteventas/pdf")
	public ResponseEntity<byte[]> verReportePDF(){
		byte[] pdf = repVentasServicios.generarReporte();
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=reporte.pdf")
				.contentType(MediaType.APPLICATION_PDF)
				.body(pdf);
	}
	@GetMapping("/reporteventas")
	public String vistaReporte() {
		return "reportes/reporteventas";
	}
}
