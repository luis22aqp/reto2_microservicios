package com.administration.contacts.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.administration.contacts.dto.ClienteDTO;

@Repository
public class ClienteRepository {

	List<ClienteDTO> listCliente = new ArrayList<ClienteDTO>();

	public ClienteRepository() {
		super();
		ClienteDTO cliente = new ClienteDTO("1", "Jorge", "Perez", 42, "03/10/1978");
		this.listCliente.add(cliente);
		
		cliente = new ClienteDTO("2", "Pedro", "Rodriguez", 30, "02/10/1989");
		this.listCliente.add(cliente);
	}

	public ClienteDTO create(ClienteDTO cliente) {
		System.out.println("- create -");
		listCliente.add(cliente);
		return cliente;
	}

	public List<ClienteDTO> getClientes() {
		System.out.println("- getClientes -");
		return listCliente;
	}

}