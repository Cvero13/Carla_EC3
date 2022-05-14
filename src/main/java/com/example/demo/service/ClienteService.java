package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ClienteRequestDTO;
import com.example.demo.dto.ClienteResponseDTO;



public interface ClienteService {
	
	public void guardarCliente(ClienteRequestDTO c);
	public void eliminarCliente(Integer id);
	public void editarCliente(ClienteRequestDTO c);
	public List<ClienteResponseDTO> listarCliente();
	public ClienteResponseDTO clienteById(Integer id);

}
