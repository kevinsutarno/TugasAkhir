package com.apap.tugasakhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugasakhir.model.JenisMedicalSuppliesModel;

public interface JenisMedicalSuppliesDB extends JpaRepository<JenisMedicalSuppliesModel, Long>{
	JenisMedicalSuppliesModel findById(long id);
}
