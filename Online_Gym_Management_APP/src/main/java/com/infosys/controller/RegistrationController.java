package com.infosys.controller;


import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infosys.model.RegistrationEntity;
import com.infosys.services.RegistrationService;

import jakarta.validation.Valid;

@RestController
//@CrossOrigin("*")
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/listusers")
    public List<RegistrationEntity> list(){
        return registrationService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationEntity> get(@PathVariable Integer id){
        try{
            RegistrationEntity registrationEntity  = registrationService.get(id);
            return new ResponseEntity<RegistrationEntity>(registrationEntity, HttpStatus.OK);

        } catch (NoSuchElementException e){
            return new ResponseEntity<RegistrationEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> add(@Valid @RequestBody RegistrationEntity registrationEntity) {
        // Check if the email already exists in the database
        if (registrationService.existsByEmail(registrationEntity.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Email is already registered");
        }

        // If email doesn't exist, save the registration entity
        registrationService.save(registrationEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(registrationEntity);
    }


    @PutMapping("/user")
    public ResponseEntity<?> update(@Valid @RequestBody RegistrationEntity registrationEntity) {
        try {
            registrationService.update(registrationEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            // Check if the entity exists
            if (!registrationService.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No such registration entity with ID: " + id);
            }

            // If the entity exists, proceed with deletion
            registrationService.delete(id);
            return ResponseEntity.ok("Registration entity with ID " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
