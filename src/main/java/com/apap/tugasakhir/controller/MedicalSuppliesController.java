package com.apap.tugasakhir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tugasakhir.model.MedicalSuppliesModel;
import com.apap.tugasakhir.repository.MedicalSuppliesDb;
import com.apap.tugasakhir.model.FlagUrgentModel;
import com.apap.tugasakhir.model.JenisMedicalSuppliesModel;
import com.apap.tugasakhir.service.FlagUrgentService;
import com.apap.tugasakhir.service.JenisMedicalSuppliesService;
import com.apap.tugasakhir.service.MedicalSuppliesService;

@Controller
public class MedicalSuppliesController {
	@Autowired
	MedicalSuppliesService medicalSuppliesService;
	
	@Autowired
	JenisMedicalSuppliesService jenisMedicalSuppliesService;
	
	@Autowired
	FlagUrgentService flagUrgentService;
	
	@Autowired
	MedicalSuppliesDb medicalSuppliesDb;
	
	@RequestMapping(value = "/medical-supplies/tambah", method = RequestMethod.GET)
	private String tambahMedicalSupplies(Model model) {
		List<JenisMedicalSuppliesModel> listJenisMedicalSupplies = jenisMedicalSuppliesService.findAll();
		model.addAttribute("listJenisMedicalSupplies", listJenisMedicalSupplies);
		model.addAttribute("medicalSupplies", new MedicalSuppliesModel());
		return "tambah-medicalSupplies";
	}
	
	@RequestMapping(value = "/medical-supplies/tambah", method = RequestMethod.POST)
	private String tambahMedicalSuppliesSubmit(@ModelAttribute MedicalSuppliesModel medicalSupplies) {
		medicalSuppliesService.addMedicalSupplies(medicalSupplies);
		return "redirect:/medical-supplies";
	}
	
	
	@RequestMapping(value = "/medical-supplies/ubah", method = RequestMethod.POST)
	private String ubahMedicalSuppliesSubmit(@ModelAttribute MedicalSuppliesModel medicalSupplies, Model model) {
		System.out.println(medicalSupplies.getId());
		MedicalSuppliesModel archive = medicalSuppliesService.getMedicalSuppliesDetail(medicalSupplies.getId());
		archive.setNama(medicalSupplies.getNama());
		archive.setJenisMedicalSupplies(medicalSupplies.getJenisMedicalSupplies());
		archive.setDeskripsi(medicalSupplies.getDeskripsi());
		archive.setPrice(medicalSupplies.getPrice());
		archive.setJenisMedicalSupplies(medicalSupplies.getJenisMedicalSupplies());
		medicalSuppliesDb.save(archive);
		model.addAttribute("medicalSupplies", archive);
		return "redirect:/medical-supplies";
	}
	
	@RequestMapping(value = "/medical-supplies/ubah/{idMedicalSupplies}", method = RequestMethod.GET)
	public String ubahMedicalSupplies(@PathVariable long idMedicalSupplies, Model model) {
		MedicalSuppliesModel archive = medicalSuppliesService.getMedicalSuppliesDetail(idMedicalSupplies);
		System.out.println(archive.getId());
		List<JenisMedicalSuppliesModel> listJenisMedicalSupplies = jenisMedicalSuppliesService.findAll();
		model.addAttribute("listJenisMedicalSupplies", listJenisMedicalSupplies);
		model.addAttribute("medicalSupplies", archive);
		return "ubah_medicalSupplies";
	}
}
