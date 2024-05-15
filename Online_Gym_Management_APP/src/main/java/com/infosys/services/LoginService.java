package com.infosys.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.model.RegistrationEntity;
import com.infosys.repository.RegistrationRepository;

@Service
public class LoginService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public boolean authenticate(String username, String password) {
        // Retrieve the user by their username
        Optional<RegistrationEntity> userOptional = registrationRepository.findByUsername(username);
        
        // Check if the user exists and if the provided password matches
        if (userOptional.isPresent()) {
            RegistrationEntity user = userOptional.get();
            return user.getPassword().equals(password);
        }
        return false;
    }
}
