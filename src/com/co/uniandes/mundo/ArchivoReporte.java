package com.co.uniandes.mundo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ArchivoReporte {
	
	PrintStream fileStream;
	
	private static ArchivoReporte archivo;
	
	
	private ArchivoReporte(String file) {
		try {
			fileStream = new PrintStream(new File(file));
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		
	}
	
	public static ArchivoReporte getArchivo(String file) {
		if (archivo == null) {
			archivo = new ArchivoReporte(file);
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
