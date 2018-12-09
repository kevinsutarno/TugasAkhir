package com.apap.tugasakhir.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.MedicalSuppliesModel;
import com.apap.tugasakhir.repository.MedicalSuppliesDb;

@Service
@Transactional
public class MedicalSuppliesServiceImpl implements MedicalSuppliesService{
	
	@Autowired 
	MedicalSuppliesDb medicalSuppliesDb;

	@Override
	public List<MedicalSuppliesModel> getListMedicalSupplies() {
		// TODO Auto-generated method stub
		return medicalSuppliesDb.findAll();
	}

  
	@Override
	public void addMedicalSupplies(MedicalSuppliesModel medicalSupplies) {
		medicalSuppliesDb.save(medicalSupplies);
	}
	
	@Override
	public MedicalSuppliesModel getMedicalSuppliesDetail(long id) {
		return medicalSuppliesDb.findById(id);
	}

}
