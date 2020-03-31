package com.co.uniandes.aspectos;
import java.util.Date;

import com.co.uniandes.modelo.Usuario;
import com.co.uniandes.mundo.ArchivoAuditoria;
import com.co.uniandes.mundo.Session;

public aspect Auditoria {
	
	pointcut auditoria() : call(* com.co.uniandes.modelo.Cuenta.*(*));
	
	after() : auditoria() {
		
		ArchivoAuditoria reporte = ArchivoAuditoria.getArchivo("auditoria.txt");
		
		
		String operacion = thisJoinPoint.getSignature().getName();
		System.out.print("Audit: " + operacion);
		long monto = (long) thisJoinPoint.getArgs()[0];
		
		Usuario usuario = Session.getSession().getUsuario();
		
		
		StringBuffer auditoria = new StringBuffer();
		auditoria.append("Facha: "+new Date().toString());
		auditoria.append(" - ");
		auditoria.append("CC: "+usuario.getCedula());
		auditoria.append(" - ");
		auditoria.append("Operacion:" + operacion);
		auditoria.append(" - ");
		auditoria.append("Monto:" + monto);
		
		reporte.registrar(auditoria.toString());
		
	}

}