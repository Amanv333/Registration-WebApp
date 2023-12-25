package com.webApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webApp.dto.RegistrationDto;
import com.webApp.entity.Registration;
import com.webApp.service.RegistrationService;
import com.webApp.util.EmailService;

@Controller
public class RegistrationController {
	@Autowired
	private RegistrationService registrationservice;
	@Autowired
	private EmailService emailservice;
	
	//http://localhost:8080/view
	//Handler methods
	@RequestMapping("/view")
	public String ViewsRegistration() {
		
		return "NewReg";
	}
//	Method - 1
//	@RequestMapping("/saveReg")
//	public String saveRegistration(Registration registration) {
//		registrationservice.saveRegistration(registration);
//		return "NewReg";
//	}
	
	
	
	//Method - 2
	
	
//	@RequestMapping("/saveReg")
//	public String saveRegistration(
//			@RequestParam("firstName") String fname,
//			@RequestParam("lastName") String lname,
//			@RequestParam("email") String email,
//			@RequestParam("mobile") long mobile,
//			ModelMap model// acts like request.setAttri... or req.getAtt...
//			
//			) {
//		Registration registration = new Registration();
//		registration.setFirstName(fname);
//		registration.setLastName(lname);
//		registration.setEmail(email);
//		registration.setMobile(mobile);
//		registrationservice.saveRegistration(registration);
//		model.addAttribute("msg","Record is saved");
//		return "NewReg";
//		
//	}
	
	//Method - 3
	 
	@RequestMapping("/saveReg")
	public String saveRegistration(
			RegistrationDto dto,// pojo class only copies the data from view in it
			ModelMap model// acts like request.setAttri... or req.getAtt...
			
			) {
		Registration registration = new Registration();
		registration.setFirstName(dto.getFirstName());
		registration.setLastName(dto.getLastName());
		registration.setEmail(dto.getEmail());
		registration.setMobile(dto.getMobile());
		
		registrationservice.saveRegistration(registration);
		emailservice.sendEmail(dto.getEmail(),"Welcome", "Testing");
		model.addAttribute("msg","Record is saved");
		return "NewReg";
		
	}
	@RequestMapping("/getAllReg")
	public String getAllregistration(Model model) {
		List<Registration> reg = registrationservice.getAllRegistrations();
		model.addAttribute("registration", reg);
		
		return "list_Reg";
	}
	
	@RequestMapping("/delete")
	public String deleteRegById(@RequestParam("id") long id,Model model) {
		registrationservice.deleteRegById(id);
		List<Registration> reg = registrationservice.getAllRegistrations();

		model.addAttribute("registration",reg);
		return "list_Reg";
	}
	@RequestMapping("/getRegistrationbyId")
	public String UpdateRegistraionById(@RequestParam("id") long id,Model model) {
		Registration registration = registrationservice.getRegistrationById(id);
		
		model.addAttribute("reg", registration);
		return"update_reg";
	}
	@RequestMapping("/UpdateReg")
	public String UpdateRegistration(Registration registration,Model model) {
		registrationservice.saveRegistration(registration);
		List<Registration> reg = registrationservice.getAllRegistrations();

		model.addAttribute("registration",reg);
		return "list_Reg";
	}

		

}
