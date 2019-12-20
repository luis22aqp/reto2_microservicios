package com.administration.contacts.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administration.contacts.dao.ClienteRepository;
import com.administration.contacts.dto.ClienteDTO;
import com.administration.contacts.dto.ClienteDatosDTO;
import com.administration.contacts.dto.ClienteEstadisticaDTO;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository dao;

	public ClienteDTO create(ClienteDTO cliente) {
		System.out.println("- ClienteService create -");
		return dao.create(cliente);
	}

	public List<ClienteDatosDTO> getClientes() {
		System.out.println("- ClienteService getClientes -");
		List<ClienteDatosDTO> listClientesDatos = new ArrayList<ClienteDatosDTO>();
		List<ClienteDTO> listClientes = dao.getClientes();
		for (ClienteDTO clienteDTO : listClientes) {

			ClienteDatosDTO clienteDato = new ClienteDatosDTO();
			clienteDato.setApellido(clienteDTO.getApellido());
			clienteDato.setNombre(clienteDTO.getNombre());
			clienteDato.setEdad(clienteDTO.getEdad());
			clienteDato.setFechaNacimiento(clienteDTO.getFechaNacimiento());

			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date dateInitial;
			Date dateFinal;
			Date date;
			String dateDead = "";
			Calendar c = Calendar.getInstance();
			try {
				dateInitial = sourceFormat.parse(clienteDTO.getFechaNacimiento());
				c.setTime(dateInitial);
				c.add(Calendar.YEAR, 50);
				dateFinal = c.getTime();
				date = getRandom(dateInitial, dateFinal);

				dateDead = formatter.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
			clienteDato.setFechaMuerte(dateDead);

			listClientesDatos.add(clienteDato);
		}
		return listClientesDatos;
	}

	public ClienteEstadisticaDTO getEstadisticaClientes() {
		System.out.println("- ClienteService getEstadisticaClientes -");

		ClienteEstadisticaDTO clienteEstadisticaDTO = new ClienteEstadisticaDTO();

		List<ClienteDTO> listClientes = dao.getClientes();
		int count = 0;
		int average = 0;
		int sum = 0;
		for (ClienteDTO cliente : listClientes) {
			sum = sum + cliente.getEdad();
			count++;
		}
		average = sum / count;

		double dif = 0;
		double square = 0;
		double sumSquare = 0;
		double variance = 0;
		double standardDeviation = 0;
		for (ClienteDTO cliente : listClientes) {
			dif = cliente.getEdad() - average;
			square = dif * dif;
			sumSquare = sumSquare + square;
			count++;
		}
		variance = sumSquare / count;
		standardDeviation = Math.sqrt(variance);

		clienteEstadisticaDTO.setListClientes(listClientes);
		clienteEstadisticaDTO.setDesviacionEstandarEdad(standardDeviation);
		clienteEstadisticaDTO.setPromedioEdad(average);
		return clienteEstadisticaDTO;
	}

	public Date getRandom(Date startInclusive, Date endExclusive) {
		long startMillis = startInclusive.getTime();
		long endMillis = endExclusive.getTime();
		long randomMillisSinceEpoch = ThreadLocalRandom.current().nextLong(startMillis, endMillis);

		return new Date(randomMillisSinceEpoch);
	}

}
