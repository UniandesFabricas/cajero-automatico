package com.co.uniandes.mundo;

import ejemplo.cajero.modelo.Usuario;

public class Session {

	private Usuario usuario;

	private static Session session;

	private Session() {

	}

	public static Session getSession() {
		if (session == null) {
			session = new Session();
		}
		return session;

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
