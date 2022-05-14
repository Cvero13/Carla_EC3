package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteRequestDTO;
import com.example.demo.dto.ClienteResponseDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepoitory;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepoitory repository;
	
	
	@Override
	public void guardarCliente(ClienteRequestDTO c) {
		Cliente cliente = new Cliente();
		cliente.setIdCliente(c.getIdRequest());		
		cliente.setNombre(c.getNombreCliente());
		cliente.setCelular(c.getCelularCliente());
		repository.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void editarCliente(ClienteRequestDTO c) {
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(c.getIdRequest());
		cliente.setNombre(c.getNombreCliente());
		cliente.setCelular(c.getCelularCliente());
		
		repository.saveAndFlush(cliente);

	}

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		List<Cliente> clientes = repository.findAll();
		
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDto = null;
		
		for (Cliente cliente:clientes) {
			clienteDto = new ClienteResponseDTO();
			
			clienteDto.setIdRespose(cliente.getIdCliente());
			clienteDto.setNombreCliente(cliente.getNombre());
			clienteDto.setCelularCliente(cliente.getCelular());
			
			dto.add(clienteDto);			
		}
		return dto;
	}

	@Override
	public ClienteResponseDTO clienteById(Integer id) {

		Cliente cliente= repository.findById(id).orElse(null);
		ClienteResponseDTO clienteDto = new ClienteResponseDTO();
		
		clienteDto = new ClienteResponseDTO();
		clienteDto.setIdRespose(cliente.getIdCliente());
		clienteDto.setNombreCliente(cliente.getNombre());
		clienteDto.setCelularCliente(cliente.getCelular());
		
		return clienteDto;
		
	}

}
