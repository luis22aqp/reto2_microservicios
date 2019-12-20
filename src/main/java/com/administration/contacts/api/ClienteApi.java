package com.administration.contacts.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.administration.contacts.dto.ClienteDTO;
import com.administration.contacts.dto.ClienteDatosDTO;
import com.administration.contacts.dto.ClienteEstadisticaDTO;
import com.administration.contacts.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Cliente Microservice", description = "API de Clientes")
public class ClienteApi {

	@Autowired
	ClienteService clienteService;

	@RequestMapping(value = "/cliente/creaCliente", method = RequestMethod.POST)
	@ApiOperation(value = "Crea un Cliente", notes = "Return Cliente creado")
	public ClienteResponse createCliente(@RequestBody ClienteRequest clienteRequest) {
		System.out.println("- ClienteApi createCliente -");

		ClienteDTO cliente = new ClienteDTO();
		cliente.setApellido(clienteRequest.getApellido());
		cliente.setNombre(clienteRequest.getNombre());
		cliente.setEdad(clienteRequest.getEdad());
		cliente.setFechaNacimiento(clienteRequest.getFechaNacimiento());

		ClienteDTO clienteRpt = clienteService.create(cliente);

		ClienteResponse clienteResponse = new ClienteResponse();
		clienteResponse.setApellido(clienteRpt.getApellido());
		clienteResponse.setNombre(clienteRpt.getNombre());
		clienteResponse.setEdad(clienteRpt.getEdad());
		clienteResponse.setFechaNacimiento(clienteRpt.getFechaNacimiento());

		return clienteResponse;
	}

	@RequestMapping(value = "/cliente/kpideclientes", method = RequestMethod.GET)
	@ApiOperation(value = "Lista los Clientes con sus KPI", notes = "Return Lista de clientes con sus KPI")
	public ClienteEstadisticaResponse getListClienteKpi() {
		System.out.println("- ClienteApi getListClienteKpi -");

		ClienteEstadisticaDTO clienteEstadistica = clienteService.getEstadisticaClientes();

		List<ClienteResponse> listClienteResponse = new ArrayList<ClienteResponse>();

		List<ClienteDTO> listClientes = clienteEstadistica.getListClientes();
		for (ClienteDTO cliente : listClientes) {
			ClienteResponse clienteResponse = new ClienteResponse();
			clienteResponse.setApellido(cliente.getApellido());
			clienteResponse.setNombre(cliente.getNombre());
			clienteResponse.setEdad(cliente.getEdad());
			clienteResponse.setFechaNacimiento(cliente.getFechaNacimiento());
			listClienteResponse.add(clienteResponse);
		}

		ClienteEstadisticaResponse clienteEstadisticaResponse = new ClienteEstadisticaResponse();
		clienteEstadisticaResponse.setListClienteResponse(listClienteResponse);
		clienteEstadisticaResponse.setDesviacionEstandarEdad(clienteEstadistica.getDesviacionEstandarEdad());
		clienteEstadisticaResponse.setPromedioEdad(clienteEstadistica.getPromedioEdad());

		return clienteEstadisticaResponse;
	}

	@RequestMapping(value = "/cliente/listclientes", method = RequestMethod.GET)
	@ApiOperation(value = "Lista de Clientes", notes = "Return Lista de clientes")
	public ListClienteDatosResponse getListCliente() {
		System.out.println("- ClienteApi getListClienteKpi -");
		
		List<ClienteDatosResponse> listClienteDatosResponse = new ArrayList<ClienteDatosResponse>();
		List<ClienteDatosDTO> listClienteDatos = clienteService.getClientes();
		for (ClienteDatosDTO clienteDatos : listClienteDatos) {
			ClienteDatosResponse clienteDatosResponse = new ClienteDatosResponse();
			clienteDatosResponse.setApellido(clienteDatos.getApellido());
			clienteDatosResponse.setNombre(clienteDatos.getNombre());
			clienteDatosResponse.setEdad(clienteDatos.getEdad());
			clienteDatosResponse.setFechaNacimiento(clienteDatos.getFechaNacimiento());
			clienteDatosResponse.setFechaMuerte(clienteDatos.getFechaMuerte());
			listClienteDatosResponse.add(clienteDatosResponse);
		}

		ListClienteDatosResponse listClienteDatosRptResponse = new ListClienteDatosResponse();
		listClienteDatosRptResponse.setListClienteDatosResponse(listClienteDatosResponse);
		return listClienteDatosRptResponse;
	}

}
