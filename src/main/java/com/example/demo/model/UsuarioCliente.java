package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "usuariocliente")
@Entity
public class UsuarioCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String usuario;
	private String password;
	private String rol;
	
	@OneToOne
	@JoinColumn(name = "id_cliente", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references cliente (id_cliente)"))
	private Cliente cliente;

	
	
	
	public UsuarioCliente() {
		super();
	}

	
	
	public UsuarioCliente(Integer idUsuario, String usuario, String password, String rol, Cliente cliente) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
		this.cliente = cliente;
	}



	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
