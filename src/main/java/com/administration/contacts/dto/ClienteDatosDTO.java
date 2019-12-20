package com.administration.contacts.dto;

import java.io.Serializable;

public class ClienteDatosDTO implements Serializable {

	private static final long serialVersionUID = 4894729030347835498L;

	String id;
	String nombre;
	String apellido;
	Integer edad;
	String fechaNacimiento;
	String fechaMuerte;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "ClienteDatosDTO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaMuerte=" + fechaMuerte + "]";
	}

}
