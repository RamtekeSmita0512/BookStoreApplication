package com.bridgelabz.BookStoreApplication.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
	  private String firstName;
	    private String lastName;
	    private String emailId;
	    private String password;
	    private Boolean verify=false;
		public int getUserId() {
			// TODO Auto-generated method stub
			return 0;
		}
		public Object addUser(RegistrationDTO registration) {
			// TODO Auto-generated method stub
			return null;
		}
		public Object getAllUser() {
			// TODO Auto-generated method stub
			return null;
		}
}
