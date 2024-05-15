package com.infosys.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.infosys.model.RegistrationEntity;
import com.infosys.repository.RegistrationRepository;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public List<RegistrationEntity> listAll(){
        return registrationRepository.findAll();
    }

    public RegistrationEntity get(int id){
        return registrationRepository.findById(id).get();

    }

    public void save(RegistrationEntity RegistrationEntity){
        registrationRepository.save(RegistrationEntity);
    }

    public RegistrationEntity update(RegistrationEntity RegistrationEntity){
        return registrationRepository.save(RegistrationEntity);
    }

    public void delete(int id){
        registrationRepository.deleteById(id);
    }

    public boolean existsByEmail(String email) {
        return registrationRepository.findByEmail(email).isPresent();
    }

	public boolean existsById(Integer id) {
		return registrationRepository.existsById(id);
	}

}
