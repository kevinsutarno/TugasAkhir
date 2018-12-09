package com.apap.tugasakhir.service;

import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.model.MedicalSuppliesModel;

public interface MedicalSuppliesService {
  List<MedicalSuppliesModel> getListMedicalSupplies();
  MedicalSuppliesModel getMedicalSuppliesDetail(long id);
  void addMedicalSupplies(MedicalSuppliesModel medicalSupplies);
}


