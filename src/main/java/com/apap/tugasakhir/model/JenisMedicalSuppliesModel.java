package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "jenis_medical_supplies")
public class JenisMedicalSuppliesModel implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@NotNull
    @Size(max = 255)
    @Column(name = "jenis_medical_supplies", nullable = false, unique = true)
    private String jenis_medical_supplies;
	
	@OneToMany(mappedBy = "jenisMedicalSupplies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<MedicalSuppliesModel> medicalJenisList;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_urgent", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private FlagUrgentModel urgent;
	
	public List<MedicalSuppliesModel> getMedicalJenisList() {
		return medicalJenisList;
	}

	public void setMedicalJenisList(List<MedicalSuppliesModel> medicalJenisList) {
		this.medicalJenisList = medicalJenisList;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJenis_medical_supplies() {
		return jenis_medical_supplies;
	}

	public void setJenis_medical_supplies(String jenis_medical_supplies) {
		this.jenis_medical_supplies = jenis_medical_supplies;
	}


	public FlagUrgentModel getUrgent() {
		return urgent;
	}

	public void setUrgent(FlagUrgentModel urgent) {
		this.urgent = urgent;
	}
	
	
}
