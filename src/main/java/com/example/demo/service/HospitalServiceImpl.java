package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.HospitalRequestDTO;
import com.example.demo.dto.HospitalResponseDTO;
import com.example.demo.model.Hospital;
import com.example.demo.repository.HospitalRepoitory;
@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	private HospitalRepoitory repository;
	
	@Override
	public void guardarHospital(HospitalRequestDTO h) {
		Hospital hospital = new Hospital();
		
		hospital.setIdHospital(h.getIdRequest());
		hospital.setNombre(h.getNombreHospital());
		hospital.setDescripcion(h.getDescripcionhospital());
		hospital.setDistrito(h.getDistritoHospital());
		
		repository.save(hospital);

	}

	@Override
	public void eliminarHospital(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarHopital(HospitalRequestDTO h) {
		
		Hospital hospital = new Hospital();
		
		hospital.setIdHospital(h.getIdRequest());
		hospital.setNombre(h.getNombreHospital());
		hospital.setDescripcion(h.getDescripcionhospital());
		hospital.setDistrito(h.getDistritoHospital());
		
		repository.saveAndFlush(hospital);

	}

	@Override
	public List<HospitalResponseDTO> listarHospital() {
		List<Hospital> hospitales = repository.findAll();
		
		List<HospitalResponseDTO> dto = new ArrayList<HospitalResponseDTO>();
		HospitalResponseDTO hospitalDto = null;
		
		for (Hospital hospital : hospitales) {
			hospitalDto = new HospitalResponseDTO();
			
			hospitalDto.setIdResponse(hospital.getIdHospital());
			hospitalDto.setNombreHospital(hospital.getNombre());
			hospitalDto.setDescripcionhospital(hospital.getDescripcion());
			hospitalDto.setDistritoHospital(hospital.getDistrito());
			
			dto.add(hospitalDto);
		}
		return dto;
	}

	@Override
	public HospitalResponseDTO hospitalById(Integer id) {
		
		Hospital hospital = repository.findById(id).orElse(null);
		HospitalResponseDTO hospitalDto = new HospitalResponseDTO();
		
		hospitalDto = new HospitalResponseDTO();		
		hospitalDto.setIdResponse(hospital.getIdHospital());
		hospitalDto.setNombreHospital(hospital.getNombre());
		hospitalDto.setDescripcionhospital(hospital.getDescripcion());
		hospitalDto.setDistritoHospital(hospital.getDistrito());
		
		return hospitalDto;
	}

}
