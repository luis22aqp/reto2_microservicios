package com.administration.contacts.api;

import java.util.List;

public class ClienteEstadisticaResponse {

	List<ClienteResponse> listClienteResponse;
	int promedioEdad;
	double desviacionEstandarEdad;

	public List<ClienteResponse> getListClienteResponse() {
		return listClienteResponse;
	}

	public void setListClienteResponse(List<ClienteResponse> listClienteResponse) {
		this.listClienteResponse = listClienteResponse;
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
