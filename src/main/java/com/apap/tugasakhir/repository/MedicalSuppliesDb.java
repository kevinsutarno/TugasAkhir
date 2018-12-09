package com.apap.tugasakhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugasakhir.model.MedicalSuppliesModel;

public interface MedicalSuppliesDb extends JpaRepository<MedicalSuppliesModel, Long> {
	MedicalSuppliesModel findById(long id);
}
