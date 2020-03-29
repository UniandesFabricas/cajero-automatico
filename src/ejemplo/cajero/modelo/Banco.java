package ejemplo.cajero.modelo;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa el Banco. Contiene una colección de cuentas
 */
public class Banco {

	private  Map<String, Usuario> usuarios = new HashMap<>();;
	
	private Usuario clienteActivo;
	
	/**
	 * Constructor sin parámetros
	 */
	public Banco() {
		
	}



	public void agregarCliente(Usuario usuario) {
		usuarios.put(usuario.getCedula(), usuario);
		
	}
	
	public Usuario autenticarCliente(String cedula, String clave) throws Exception {
		
		Usuario usuario = usuarios.get(cedula);
		if (usuario == null || !usuario.getClave().equals(clave)) {
			throw new Exception("Usuario o clave invalida");
		}
		return usuario;
		
	}



	public Usuario getClienteActivo() {
		return clienteActivo;
	}



	public void setClienteActivo(Usuario clienteActivo) {
		this.clienteActivo = clienteActivo;
	}
	
	
	
	
	



	
}
