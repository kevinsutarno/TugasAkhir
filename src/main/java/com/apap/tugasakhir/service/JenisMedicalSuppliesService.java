package com.apap.tugasakhir.service;

import java.util.List;
import com.apap.tugasakhir.model.JenisMedicalSuppliesModel;

public interface JenisMedicalSuppliesService {
	JenisMedicalSuppliesModel findById(long id);
	List<JenisMedicalSuppliesModel> findAll();
}
