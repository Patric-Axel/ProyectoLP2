package com.proyecto.service;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
@Service
public class ReporteProductoServicio {
	private final DataSource dataSource;
	
	public ReporteProductoServicio(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public byte[] generarReporte() {
		try (Connection conn = dataSource.getConnection()){
			InputStream reporteStream = getClass()
					.getResourceAsStream("/reportes/reporte_productosMasVendidos.jasper");
			JasperReport reporte = (JasperReport) JRLoader.loadObject(reporteStream);
			Map<String, Object> parametros = new HashMap<>(); //si utilizas parámetros
			// Ejemplo: parametros.put("id",1);
			JasperPrint print = JasperFillManager.fillReport(reporte, parametros,conn);
			return JasperExportManager.exportReportToPdf(print);
			
		}
		catch (Exception e) {
			throw new RuntimeException("Error al generar el reporte", e);
		}
	}
}
