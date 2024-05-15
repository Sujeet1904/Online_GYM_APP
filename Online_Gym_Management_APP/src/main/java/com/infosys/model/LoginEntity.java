package com.infosys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoginEntity {
    
    @Id
    private String username;
    private String password;
    
    
}
