package com.webApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javamailsender;

	public void sendEmail(String to,String subject,String message) {
		SimpleMailMessage sm = new SimpleMailMessage();
	sm.setTo(to);
	sm.setSubject(subject);
	sm.setText(message);
	javamailsender.send(sm);
	}
}
