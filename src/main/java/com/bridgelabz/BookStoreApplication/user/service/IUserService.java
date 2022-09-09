package com.bridgelabz.BookStoreApplication.user.service;

import javax.servlet.Registration;

import com.bridgelabz.BookStoreApplication.user.model.User;
import com.bridgelabz.BookStoreApplication.utility.LoginDTO;
import com.bridgelabz.BookStoreApplication.utility.RegistrationDTO;
import com.bridgelabz.BookStoreApplication.utility.Response;
import com.bridgelabz.BookStoreApplication.utility.UserDTO;

public interface IUserService {
	
	 Response getAllUsers();
	    Response getUsersById(int id);
	    Response createNewUsers(UserDTO userDto);
	    Response updateUser(int id, UserDTO userDto );
	    Response deleteUsersById(int id);
		Response loginValidation(LoginDTO loginDTO);
		User forgotPassword(String emailId, String password);
		
		
	}


