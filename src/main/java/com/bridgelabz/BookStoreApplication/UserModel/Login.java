package com.bridgelabz.BookStoreApplication.UserModel;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Service
public class Login {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO )
	 private  int id;
	 
	 private String userName;
	    private String password;
	   
	     
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Integer CheckLogin(Login login) {
			
			return null;
		}
		public static Login Build(Object userName2, Object password2, boolean b, int id2) {
			// TODO Auto-generated method stub
			return null;
		}
		public Object checkLogin(Login login) {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	    
}
