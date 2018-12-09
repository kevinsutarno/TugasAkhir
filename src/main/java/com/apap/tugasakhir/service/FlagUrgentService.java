package com.apap.tugasakhir.service;

import java.util.List;

import com.apap.tugasakhir.model.FlagUrgentModel;

public interface FlagUrgentService {
	FlagUrgentModel findById(long id);
	List<FlagUrgentModel> findAll();
}
