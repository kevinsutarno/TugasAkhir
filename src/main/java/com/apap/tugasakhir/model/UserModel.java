package com.apap.tugasakhir.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {
	@NotNull
    @Size(max = 255)
    @Column(name = "username", nullable = false, unique = true)
    private String username;
	
	@NotNull
    @Size(max = 255)
    @Column(name = "password", nullable = false)
    private String password;
	
	@NotNull
    @Size(max = 255)
    @Column(name = "role", nullable = false)
    private String role;
}
