package com.apap.tugasakhir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugasakhir.model.FlagUrgentModel;

public interface FlagUrgentDB extends JpaRepository<FlagUrgentModel, Long>{
	FlagUrgentModel findById(long id);
}
