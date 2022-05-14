package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UsuarioCliente;

@Repository
public interface UsuarioRepoitory extends JpaRepository<UsuarioCliente, Integer>{

}
