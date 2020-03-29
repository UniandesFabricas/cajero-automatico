package com.co.uniandes.mundo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.co.uniandes.control.Comando;
import com.co.uniandes.control.ComandoConsignar;
import com.co.uniandes.control.ComandoListarCuentas;
import com.co.uniandes.control.ComandoRetirar;
import com.co.uniandes.control.ComandoTransferir;
import com.co.uniandes.modelo.Banco;
import com.co.uniandes.modelo.Cuenta;
import com.co.uniandes.modelo.Usuario;

/**
 * Simulador de un Cajero de Banco
 */
public class Cajero {

	

	/**
	 * Programa principal
	 * 
	 * @param args parámetros de línea de comandos. Son ignorados por el programa.
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		// crea el banco
		Banco banco = new Banco();		
		Usuario u1 = new Usuario("123", "123");
		u1.agregarCuenta(new Cuenta("1", "clave", 1000000));
		u1.agregarCuenta(new Cuenta("2", "clave", 250000));
		u1.agregarCuenta(new Cuenta("3", "clave", 300000));
		
		Usuario u2 = new Usuario("666", "666");
		u2.agregarCuenta(new Cuenta("11", "clave", 850000));
		u2.agregarCuenta(new Cuenta("22", "clave", 200000));
		
		Usuario u3 = new Usuario("1234", "1234");
		u3.agregarCuenta(new Cuenta("111", "clave", 500000));
		u3.agregarCuenta(new Cuenta("222", "clave", 300000));
		
		banco.agregarCliente(u1);
		banco.agregarCliente(u2);
		banco.agregarCliente(u3);
	

		
		
		Usuario usuario = autenticar(banco);
		if (usuario != null) {
			Session.getSession().setUsuario(usuario);
			banco.setClienteActivo(usuario);
			cicloPrograma(banco);
		}

	}

	/**
	 * 
	 */
	private static void cicloPrograma(Banco banco) {

		// crea los comandos que se van a usar en la aplicación
		List<Comando> comandos = cargaComandos();

		// Ciclo del Programa
		// ==================

		System.out.println("Cajero Automático");
		System.out.println("=================");
		System.out.println();

		boolean fin = false;
		do {

			// muestra los nombres de los comandos
			muestraMenuConComandos(comandos);
			System.out.println("X.- Salir");

			// la clase Console no funciona bien en Eclipse
			Scanner console = new Scanner(System.in);
			String valorIngresado = console.nextLine();

			// obtiene el comando a ejecutar
			Comando comandoSeleccionado = retornaComandoSeleccionado(comandos, valorIngresado);
			if (comandoSeleccionado != null) {

				// intenta ejecutar el comando
				try {

					comandoSeleccionado.ejecutar(banco);

				} catch (Exception e) {
					// si hay una excepción, muestra el mensaje
					System.err.println(e.getMessage());
				}

			}
			// si no se obtuvo un comando, puede ser la opción de salir
			else if (valorIngresado.equalsIgnoreCase("X")) {
				fin = true;
			}

			System.out.println();
		} while (!fin);

		System.out.println("Gracias por usar el programa.");

	}

	/**
	 * 
	 * @param banco
	 * @return
	 */
	private static Usuario autenticar(Banco banco) {
		boolean auth = false;
		Usuario usuario = null;	
		do {
				
			System.out.println("Autenticar");
			System.out.println("=================");
			System.out.println();

			Scanner console = new Scanner(System.in);

			System.out.println("Ingrese su cedula");
			String cc = console.nextLine();

			System.out.println("Ingrese su clave");
			String clave = console.nextLine();

			try {
				usuario = banco.autenticarCliente(cc, clave);
				auth = true;
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
				System.out.println();
				
			}
			
		} while (!auth);
		

		return usuario;
	}

	// Manejo de los comandos de la aplicación
	// =======================================

	// carga los comandos usados en el programa
	private static List<Comando> cargaComandos() {

		// crea los comandos que se van a usar en la aplicación
		List<Comando> comandos = new ArrayList<>();

		comandos.add(new ComandoListarCuentas());
		comandos.add(new ComandoRetirar());
		comandos.add(new ComandoConsignar());
		comandos.add(new ComandoTransferir());

		return comandos;
	}

	// Muestra el listado de comandos, para mostrar un menú al usuario
	// muestra el índice en el arreglo de comandos y el nombre del comando
	private static void muestraMenuConComandos(List<Comando> comandos) {

		// muestra los nombres de los comandos
		for (int i = 0; i < comandos.size(); i++) {
			System.out.println(i + ".-" + comandos.get(i).getNombre());
		}
	}

	// dado el texto ingresado por el usuario, retorna el comando correspondiente
	// retorna null si el texto no es un número o no existe ningún comando con ese
	// índice
	private static Comando retornaComandoSeleccionado(List<Comando> comandos, String valorIngresado) {

		Comando comandoSeleccionado = null;

		// el valorIngresado es un número ?
		if (valorIngresado.matches("[0-9]")) {
			int valorSeleccionado = Integer.valueOf(valorIngresado);
			// es un índice válido para la lista de comandos
			if (valorSeleccionado < comandos.size()) {
				comandoSeleccionado = comandos.get(valorSeleccionado);
			}
		}

		return comandoSeleccionado;
	}

}
