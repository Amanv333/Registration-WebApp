package com.webApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webApp.entity.Registration;
import com.webApp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private  RegistrationRepository registrationrepository;
	
	public void saveRegistration(Registration registration) {
		registrationrepository.save(registration);
		
	}

	public List<Registration> getAllRegistrations() {
		
		List<Registration> regs = registrationrepository.findAll();
		return regs;
	}

	public void deleteRegById(long id) {
		// TODO Auto-generated method stub
		registrationrepository.deleteById(id);
		
	}

	public Registration getRegistrationById(long id) {
		Registration reg= registrationrepository.findById(id).get();
		return reg;
	}

}
