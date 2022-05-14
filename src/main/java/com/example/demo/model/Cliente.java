package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "cliente")
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String nombre;
	private String celular;
	
	@OneToOne(mappedBy = "cliente") 
	private  UsuarioCliente usuario;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "hospital_cliente",
	joinColumns = @JoinColumn(name="id_cliente", nullable = false, unique = true,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references cliente (id_cliente)")),
	inverseJoinColumns = @JoinColumn(name="id_hospital", nullable = false, unique = true,
	foreignKey =  @ForeignKey(foreignKeyDefinition = "foreign key (id_hospital) references hospital (id_hospital)")))	
	private List<Hospital> hospitales=new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer idCliente, String nombre, String celular, UsuarioCliente usuario,
			List<Hospital> hospitales) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.celular = celular;
		this.usuario = usuario;
		this.hospitales = hospitales;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public UsuarioCliente getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioCliente usuario) {
		this.usuario = usuario;
	}

	public List<Hospital> getHospitales() {
		return hospitales;
	}

	public void setHospitales(List<Hospital> hospitales) {
		this.hospitales = hospitales;
	}

	
	
	
}
