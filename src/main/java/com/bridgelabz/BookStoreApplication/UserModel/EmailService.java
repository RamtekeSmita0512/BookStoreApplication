package com.bridgelabz.BookStoreApplication.UserModel;


import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmailService {
	
	

	public String sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("smitaramteke5@gmail.com");
		message.setTo("smitaramteke5@gmail.com");
		message.setSubject("Test Subject");
		message.setText("Test Body");
		
		SimpleMailMessage.send(message);
		return "Mail send Successfully";
	}

	
	

}


    