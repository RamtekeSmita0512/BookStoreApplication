package com.bridgelabz.BookStoreApplication.UserService;

import com.bridgelabz.BookStoreApplication.UserModel.Login;
import com.bridgelabz.BookStoreApplication.Utility.Response;
import com.bridgelabz.BookStoreApplication.Utility.UserDTO;

public interface IUserService {
	
	 Response getAllUsers();
	    Response getUsersById(int id);
	    Response createNewUsers(UserDTO userDto);
	    Response updateUser(int id, UserDTO userDto );
	    Response deleteUsersById(int id);
		Login loginCheck(UserDTO userDto);
	}


