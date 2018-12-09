package com.apap.tugasakhir.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugasakhir.model.FlagUrgentModel;
import com.apap.tugasakhir.repository.FlagUrgentDB;

@Service
@Transactional
public class FlagUrgentServiceImpl implements FlagUrgentService {
	@Autowired
	private FlagUrgentDB flagUrgentDb;
	
	@Override
	public FlagUrgentModel findById(long id) {
		return flagUrgentDb.findById(id);
	}

	@Override
	public List<FlagUrgentModel> findAll() {
		return flagUrgentDb.findAll();
	}
	
	
}
