package com.administration.contacts.dto;

import java.io.Serializable;
import java.util.List;

public class ClienteEstadisticaDTO implements Serializable {

	private static final long serialVersionUID = 4894729030347835498L;

	List<ClienteDTO> listClientes;
	int promedioEdad;
	double desviacionEstandarEdad;

	public List<ClienteDTO> getListClientes() {
		return listClientes;
	}

	public void setListClientes(List<ClienteDTO> listClientes) {
		this.listClientes = listClientes;
	}

	public int getPromedioEdad() {
		return promedioEdad;
	}

	public void setPromedioEdad(int promedioEdad) {
		this.promedioEdad = promedioEdad;
	}

	public double getDesviacionEstandarEdad() {
		return desviacionEstandarEdad;
	}

	public void setDesviacionEstandarEdad(double desviacionEstandarEdad) {
		this.desviacionEstandarEdad = desviacionEstandarEdad;
	}
}
