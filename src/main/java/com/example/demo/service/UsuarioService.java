package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UsuarioRequestDTO;
import com.example.demo.dto.UsuarioResponseDTO;


public interface UsuarioService {

	public void guardarUsuario(UsuarioRequestDTO u);
	public void eliminarUsuario(Integer id);
	public void editarUsuario(UsuarioRequestDTO u);
	public List<UsuarioResponseDTO> listarUsuario();
	public UsuarioResponseDTO usuarioById(Integer id);
}
