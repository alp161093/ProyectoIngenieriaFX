package application;

import java.io.Serializable;

public class Usuario implements Serializable{
	private String nombre, password;
	private boolean esAdmin = false;
	
	public Usuario() {
		
	}
	
	public Usuario(String nom, String pass, boolean esAdmin) {
		this.nombre = nom;
		this.password = pass;
		this.esAdmin = esAdmin;
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	
}
