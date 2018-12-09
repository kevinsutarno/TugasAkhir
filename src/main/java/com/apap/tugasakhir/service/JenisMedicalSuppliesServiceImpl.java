package com.apap.tugasakhir.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.model.JenisMedicalSuppliesModel;
import com.apap.tugasakhir.repository.JenisMedicalSuppliesDB;

@Service
@Transactional
public class JenisMedicalSuppliesServiceImpl implements JenisMedicalSuppliesService{
	@Autowired
	JenisMedicalSuppliesDB jenisMedicalSuppliesDb;
	
	@Override
	public JenisMedicalSuppliesModel findById(long id) {

		return jenisMedicalSuppliesDb.findById(id);
	}

	@Override
	public List<JenisMedicalSuppliesModel> findAll() {
		
		return jenisMedicalSuppliesDb.findAll();
	}

}
