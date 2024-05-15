package com.infosys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infosys.model.RegistrationEntity;

@Repository
public interface RegistrationRepository extends JpaRepository<RegistrationEntity,Integer> {
	
	Optional<RegistrationEntity> findByUsername(String username);

	Optional<RegistrationEntity> findByEmail(String email);
	
}
