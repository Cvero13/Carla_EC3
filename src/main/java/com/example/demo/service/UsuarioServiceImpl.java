package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioRequestDTO;
import com.example.demo.dto.UsuarioResponseDTO;
import com.example.demo.model.UsuarioCliente;
import com.example.demo.repository.UsuarioRepoitory;

@Service
public class UsuarioServiceImpl implements UsuarioService {


	@Autowired
	private UsuarioRepoitory repository;	
	
	@Override
	public void guardarUsuario(UsuarioRequestDTO u) {

		UsuarioCliente usuario = new UsuarioCliente();
		usuario.setIdUsuario(u.getIdRequest());
		usuario.setUsuario(u.getNombreusuario());
		usuario.setPassword(u.getPasswordusuario());
		usuario.setRol(u.getRolusuario());
		repository.save(usuario);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public void editarUsuario(UsuarioRequestDTO u) {
		
		UsuarioCliente usuario = new UsuarioCliente();
		
		usuario.setIdUsuario(u.getIdRequest());
		usuario.setUsuario(u.getNombreusuario());
		usuario.setPassword(u.getPasswordusuario());
		usuario.setRol(u.getRolusuario());
		
		repository.saveAndFlush(usuario);

	}

	@Override
	public List<UsuarioResponseDTO> listarUsuario() {
		
		List<UsuarioCliente> usuarios = repository.findAll();
		
		List<UsuarioResponseDTO> dto = new ArrayList<UsuarioResponseDTO>();
		UsuarioResponseDTO usuarioDto = null;
		
		for (UsuarioCliente usuario : usuarios) {
			usuarioDto = new UsuarioResponseDTO();
			
			usuarioDto.setIdRespose(usuario.getIdUsuario());
			usuarioDto.setNombreusuario(usuario.getUsuario());
			usuarioDto.setPasswordusuario(usuario.getPassword());
			usuarioDto.setRolusuario(usuario.getRol());
			
			dto.add(usuarioDto);
		}
		return dto;
	}

	@Override
	public UsuarioResponseDTO usuarioById(Integer id) {

		UsuarioCliente usuario = repository.findById(id).orElse(null);
		UsuarioResponseDTO usuarioDto = new UsuarioResponseDTO();
		
		usuarioDto = new UsuarioResponseDTO();		
		usuarioDto.setIdRespose(usuario.getIdUsuario());
		usuarioDto.setNombreusuario(usuario.getUsuario());
		usuarioDto.setPasswordusuario(usuario.getPassword());
		usuarioDto.setRolusuario(usuario.getRol());
		
		return usuarioDto;
		
	}

}
