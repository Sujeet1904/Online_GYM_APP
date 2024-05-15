package com.infosys.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RegistrationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uniqueId;
	private String firstName;
	private String lastName;
    private String email;
    private String contactNumber;
    private String username;
    private String password;
  
    
}
