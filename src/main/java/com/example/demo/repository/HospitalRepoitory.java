package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Hospital;

@Repository
public interface HospitalRepoitory extends JpaRepository<Hospital, Integer>{

}
