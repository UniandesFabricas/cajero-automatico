package com.co.uniandes.control;

import com.co.uniandes.modelo.Banco;
import com.co.uniandes.modelo.Cuenta;
import com.co.uniandes.modelo.Usuario;

/**
 * Comando usado para listar las cuentas 
 */
public class ComandoListarCuentas implements Comando {

	@Override
	public String getNombre() {
		return "Consulta Saldos";
	}

	@Override
	public void ejecutar(Banco contexto) throws Exception {
		
		System.out.println("Listado de Cuentas");
		System.out.println();
	
		for (Cuenta cuenta : contexto.getClienteActivo().getCuentas()) {
			System.out.println(cuenta.getNumero() + " : $ " + cuenta.getSaldo());
		}

	}

}
