package com.bridgelabz.BookStoreApplication.user.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data

@Service
public class EmailService {
	
	
		@Autowired
		private JavaMailSender javaMailSender;
		
		public String sendEmail() {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("smitaramteke5@gmail.com");
			message.setTo("smitaramteke5@gmail.com");
			message.setSubject("dummy subject");
			message.setText("dummy text");
			
			javaMailSender.send(message);
			
			return "Mail sent Successfully";
		}

		public void sendEmail(Object emailId, String string, String string2) {
			// TODO Auto-generated method stub
			
		}

	
	

}


    