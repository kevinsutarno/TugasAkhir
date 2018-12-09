package com.apap.tugasakhir.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="flag_urgent")
public class FlagUrgentModel implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@NotNull
    @Size(max = 50)
    @Column(name = "deskripsi_flag_urgent", nullable = false)
    private String deskripsi_flag_urgent;
	
	@NotNull
	@Column(name = "flag", nullable = false)
    private int flag;
	
	@OneToMany(mappedBy = "urgent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<JenisMedicalSuppliesModel> jenisFlagList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeskripsi_flag_urgent() {
		return deskripsi_flag_urgent;
	}

	public void setDeskripsi_flag_urgent(String deskripsi_flag_urgent) {
		this.deskripsi_flag_urgent = deskripsi_flag_urgent;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
	
}
