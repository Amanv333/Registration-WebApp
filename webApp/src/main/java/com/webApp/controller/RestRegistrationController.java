package com.webApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webApp.dto.RegistrationDto;
import com.webApp.entity.Registration;
import com.webApp.repository.RegistrationRepository;

@RestController
@RequestMapping("/api/registration")
public class RestRegistrationController {
	@Autowired
	private RegistrationRepository registrationRepository;
	
	
	//http://localhost:8080/api/registration
	@GetMapping
	public List<Registration> getAllReg(){
		List<Registration> Reg = registrationRepository.findAll();
		return Reg;
	}
	
	
	//http://localhost:8080/api/registration/2
	@DeleteMapping("/{id}")
	public void DeleteReg(@PathVariable long id) {
		registrationRepository.deleteById(id);
	}
	
	//http://localhost:8080/api/registration
	@PostMapping
	public void saveReg(@RequestBody Registration reg) {
		registrationRepository.save(reg);
	}
	
	@PutMapping
	public void updateReg(@RequestParam long id,@RequestBody RegistrationDto regDto) {
		Registration reg= registrationRepository.findById(id).get();
		reg.setFirstName(regDto.getFirstName());
		reg.setLastName(regDto.getLastName());
		reg.setEmail(regDto.getEmail());
		reg.setMobile(regDto.getMobile());
		
		registrationRepository.save(reg);
	}
	
}
