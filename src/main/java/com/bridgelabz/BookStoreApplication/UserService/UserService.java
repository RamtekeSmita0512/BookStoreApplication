package com.bridgelabz.BookStoreApplication.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.BookStoreApplication.UserModel.User;
import com.bridgelabz.BookStoreApplication.UserRepository.UserRepository;
import com.bridgelabz.BookStoreApplication.Utility.Response;
import com.bridgelabz.BookStoreApplication.Utility.UserDTO;


@Service
public class UserService implements IUserService{
	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ModelMapper modelMapper;

	    @Autowired
	    private Response response;

	    public Response getAllUsers() {
	        return new Response();
	    }

	    @Override
	    public Response getUsersById(int id) {
	        return new Response();
	    }

	    public Response creatNewUsers(UserDTO userDto) {
	        User user = modelMapper.map(userDto, User.class);
	        userRepository.save(user);
	       
	        Response object =new Response( );
	        return object;
	    }

	    public Response updateUser(int id, UserDTO userDto) {
	        User user = modelMapper.map(userDto, User.class);
	        userRepository.save(user);
	       
	        return new Response();
	    }

	    @Override
	    public Response deleteUsersById(int id) {
	        return null;
	    }

	    public Response deleteUser(int id) {
	        return new Response();

	    }

		public Response getResponse() {
			return response;
		}

		public void setResponse(Response response) {
			this.response = response;
		}

		@Override
		public Response createNewUsers(UserDTO userDto) {
			// TODO Auto-generated method stub
			return null;
		}

}