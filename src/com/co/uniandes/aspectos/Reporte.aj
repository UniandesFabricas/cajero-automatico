package com.co.uniandes.aspectos;
import com.co.uniandes.mundo.ArchivoReporte;

public aspect Reporte {

	pointcut operaciones() : call (* com.co.uniandes.modelo..*(..));

	after()  : operaciones() {

		ArchivoReporte reporte = ArchivoReporte.getArchivo("operaciones.txt");

		reporte.registrar(thisJoinPoint.getSignature().getName());

	}
}