package ejemplo.cajero.modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Usuario {

	private String cedula;
	private String clave;
	
	
	

	// mapa con las cuentas. la llave es el número de la cuenta
	private Map<String, Cuenta> cuentas = new HashMap<>();
	
	
	public Usuario(String cedula, String clave) {
		this.cedula = cedula;
		this.clave = clave;
		
	}
	
	/**
	 * Retorna un listado con las cuentas
	 * @return listado con las cuentas del Banco-
	 */
	public Collection<Cuenta> getCuentas() {
		return cuentas.values();
	}
	
	/**
	 * Busca una cuenta por el número.  
	 * Retorna una cuenta, si la encuentra, o null, si no la encuentra 
	 * @param numero número de la cuenta a buscar
	 * @return	instancia de cuenta con ese número, null si no existe
	 */
	public Cuenta buscarCuenta(String numero) {
		return cuentas.get(numero);
	}

	/**
	 * agrega una cuenta al banco
	 * @param cuenta Cuenta a agregar al banco
	 */
	public void agregarCuenta(Cuenta cuenta) {
		cuentas.put(cuenta.getNumero(), cuenta);
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	

}
