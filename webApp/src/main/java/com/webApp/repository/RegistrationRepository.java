package com.webApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webApp.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
	

}
