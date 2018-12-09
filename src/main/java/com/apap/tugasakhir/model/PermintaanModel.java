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
@Table(name = "permintaan")
public class PermintaanModel implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @Column(name = "tanggal", nullable = false)
    private Date tanggal;
	
	@NotNull
	@Column(name = "jumlah_medical_supplies", nullable = false)
    private int jumlah_medical_supplies;
	
	@NotNull
	@Column(name = "id_pasien", nullable = false)
    private int id_pasien;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_medical_supplies", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private MedicalSuppliesModel medicalSupplies;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_jadwal", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JadwalJagaModel jadwalJaga;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_status_permintaan", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private StatusPermintaanModel statusPermintaan;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public int getJumlah_medical_supplies() {
		return jumlah_medical_supplies;
	}

	public void setJumlah_medical_supplies(int jumlah_medical_supplies) {
		this.jumlah_medical_supplies = jumlah_medical_supplies;
	}

	public int getId_pasien() {
		return id_pasien;
	}

	public void setId_pasien(int id_pasien) {
		this.id_pasien = id_pasien;
	}

	public MedicalSuppliesModel getMedicalSupplies() {
		return medicalSupplies;
	}

	public void setMedicalSupplies(MedicalSuppliesModel medicalSupplies) {
		this.medicalSupplies = medicalSupplies;
	}

	public JadwalJagaModel getJadwalJaga() {
		return jadwalJaga;
	}

	public void setJadwalJaga(JadwalJagaModel jadwalJaga) {
		this.jadwalJaga = jadwalJaga;
	}

	public StatusPermintaanModel getStatusPermintaan() {
		return statusPermintaan;
	}

	public void setStatusPermintaan(StatusPermintaanModel statusPermintaan) {
		this.statusPermintaan = statusPermintaan;
	}
	
	
}
