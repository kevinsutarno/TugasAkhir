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

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name = "jadwal_jaga")
public class JadwalJagaModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "tanggal", nullable = false)
    private Date tanggal;
    
    @NotNull
    @Column(name = "waktu_mulai", nullable = false)
    private Date waktu_mulai;

    @NotNull
    @Column(name = "waktu_selesai", nullable = false)
    private Date waktu_selesai;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_staff", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private StaffModel staff;
    
    @OneToMany(mappedBy = "jadwalJaga", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PermintaanModel> jadwalPermintaanList;
    
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

	public Date getWaktu_mulai() {
		return waktu_mulai;
	}

	public void setWaktu_mulai(Date waktu_mulai) {
		this.waktu_mulai = waktu_mulai;
	}

	public Date getWaktu_selesai() {
		return waktu_selesai;
	}

	public void setWaktu_selesai(Date waktu_selesai) {
		this.waktu_selesai = waktu_selesai;
	}

	public StaffModel getStaff() {
		return staff;
	}

	public void setStaff(StaffModel staff) {
		this.staff = staff;
	}
	
}
