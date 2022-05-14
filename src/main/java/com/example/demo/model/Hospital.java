package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name = "Hospital")
@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHospital;
	private String nombre;
	private String descripcion;
	private String distrito;
	
	
	@ManyToMany(mappedBy = "hospitales", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Cliente> clientes = new ArrayList<>();


	public Hospital() {
		super();
	}


	public Hospital(Integer idHospital, String nombre, String descripcion, String distrito, List<Cliente> clientes) {
		super();
		this.idHospital = idHospital;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distrito = distrito;
		this.clientes = clientes;
	}


	public Integer getIdHospital() {
		return idHospital;
	}


	public void setIdHospital(Integer idHospital) {
		this.idHospital = idHospital;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	
}
