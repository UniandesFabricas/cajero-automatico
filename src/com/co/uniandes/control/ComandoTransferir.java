package com.co.uniandes.control;

import java.util.Scanner;

import com.co.uniandes.modelo.Banco;
import com.co.uniandes.modelo.Cuenta;

/**
 * Comando usado para transferir dinero entre cuentas
 */
public class ComandoTransferir implements Comando {

	@Override
	public String getNombre() {
		return "Transferir dinero";
	}

	@SuppressWarnings("resource")
	@Override
	public void ejecutar(Banco contexto) throws Exception {
		
		System.out.println("Transferencia de Dinero");
		System.out.println();
		
		// la clase Console no funciona bien en Eclipse
		Scanner console = new Scanner(System.in);			
		
		// Ingresa los datos
		System.out.println("Ingrese el número de cuenta origen");
		String numeroCuentaOrigen = console.nextLine();
		
		Cuenta cuentaOrigen = contexto.getClienteActivo().buscarCuenta(numeroCuentaOrigen);
		if (cuentaOrigen == null) {
			throw new Exception("No existe cuenta con el número " + numeroCuentaOrigen);
		}

		System.out.println("Ingrese el número de cuenta destino");
		String numeroCuentaDestino = console.nextLine();
		
		Cuenta cuentaDestino = contexto.getClienteActivo().buscarCuenta(numeroCuentaDestino);
		if (cuentaDestino == null) {
			throw new Exception("No existe cuenta con el número " + numeroCuentaDestino);
		}
		
		System.out.println("Ingrese el valor a transferir");
		String valor = console.nextLine();
	
		try {
			
			// se retira primero y luego se consigna
			// si no se puede retirar, no se hace la consignación
			
			long valorNumerico = Long.parseLong(valor);
			cuentaOrigen.retirar(valorNumerico);
			cuentaDestino.consignar(valorNumerico);
		
		} catch (NumberFormatException e) {
			throw new Exception("Valor a transferir no válido : " + valor);
		}
	}

}
