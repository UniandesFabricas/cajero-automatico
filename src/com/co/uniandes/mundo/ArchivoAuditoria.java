package com.co.uniandes.mundo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ArchivoAuditoria {
	
	PrintStream fileStream;
	
	private static ArchivoAuditoria archivo;
	
	
	private ArchivoAuditoria(String file) {
		try {
			fileStream = new PrintStream(new File(file));
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		
	}
	
	public static ArchivoAuditoria getArchivo(String file) {
		if (archivo == null) {
			archivo = new ArchivoAuditoria(file);
		}
		return archivo;
	}
	
	/**
	 * 
	 * @param aud
	 */
	public void registrar(String registro) {
		fileStream.println(registro);
		
	}

}
