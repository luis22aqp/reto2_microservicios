package com.administration.contacts.api;

public class ClienteDatosResponse {

	String nombre;
	String apellido;
	Integer edad;
	String fechaNacimiento;
	String fechaMuerte;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaMuerte() {
		return fechaMuerte;
	}

	public void setFechaMuerte(String fechaMuerte) {
		this.fechaMuerte = fechaMuerte;
	}

}
