package com.apap.tugasakhir.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.apap.tugasakhir.model.MedicalSuppliesModel;
import com.apap.tugasakhir.service.MedicalSuppliesService;

@Controller
public class PageController {
	
	@Autowired MedicalSuppliesService medicalSuppliesService;
	
	@RequestMapping("/")
	public String home () {
		return "home";	
	}
	
	@RequestMapping(value = "/medical-supplies", method = RequestMethod.GET)
	private String viewMedicalSupplies(Model model) {
		List <MedicalSuppliesModel> listOfMedicalSupplies = medicalSuppliesService.getListMedicalSupplies();
		model.addAttribute("listOfMedicalSupplies", listOfMedicalSupplies);	
		
		return "medicalSuppliesList";
	}
	
	@RequestMapping(value = "/medical-supplies/{id}", method = RequestMethod.GET)
	private String viewMedicalSuppliesDetail(@PathVariable(value = "id") Long id, Model model) {
		System.out.println(id);
		MedicalSuppliesModel medicalSupplies = medicalSuppliesService.getMedicalSuppliesDetail(id);
		if (medicalSupplies != null) {
			model.addAttribute("medicalSupplies", medicalSupplies);
		} else {
			model.addAttribute("medicalSupplies", new MedicalSuppliesModel());
		}
		
		return "medicalSuppliesDetail";
	}
}
