package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "perencanaan")
public class PerencanaanModel implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@NotNull
    @Size(max = 255)
    @Column(name = "status", nullable = false)
    private String status;
	
	@NotNull
    @Column(name = "tanggal", nullable = false)
    private Date tanggal;
	
	@NotNull
	@Column(name = "jumlah", nullable = false)
    private int jumlah;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_medical_supplies", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MedicalSuppliesModel medicalSupplies;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public MedicalSuppliesModel getMedicalSupplies() {
		return medicalSupplies;
	}

	public void setMedicalSupplies(MedicalSuppliesModel medicalSupplies) {
		this.medicalSupplies = medicalSupplies;
	}
	
	
}
