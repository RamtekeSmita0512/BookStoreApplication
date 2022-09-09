package com.bridgelabz.BookStoreApplication.user.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.BookStoreApplication.exception.GlobalException;
import com.bridgelabz.BookStoreApplication.user.model.User;
import com.bridgelabz.BookStoreApplication.user.repository.UserRepository;
import com.bridgelabz.BookStoreApplication.user.util.EmailService;
import com.bridgelabz.BookStoreApplication.user.util.TokenUtil;
import com.bridgelabz.BookStoreApplication.utility.LoginDTO;
import com.bridgelabz.BookStoreApplication.utility.RegistrationDTO;
import com.bridgelabz.BookStoreApplication.utility.Response;
import com.bridgelabz.BookStoreApplication.utility.UserDTO;


@Service
public class UserService implements IUserService{
	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private ModelMapper modelMapper;
	    
	    @Autowired
	    private EmailService emailService;


	    @Autowired
	    private TokenUtil tokenUtil;

	   
		
	    public Response getAllUsers() {
	        return new Response();
	    }

	    @Override
	    public Response getUsersById(int id) {
	        return new Response();
	    }

	    public Response createNewUsers(UserDTO userDto) {
	        User user = modelMapper.map(userDto, User.class);
	        userRepository.save(user);
	       
	        Response object =new Response("User added Successfully", 200, user );
	        return object;
	    }
	   

	    public Response updateUser(int id, UserDTO userDto) {
	        User user = modelMapper.map(userDto, User.class);
	        userRepository.save(user);
	       
	        return new Response("User update Successfully", 200, user);
	    }
	    @Override
	    public Response loginValidation(LoginDTO loginDTO) {
	        String token;
	        Optional<User> isUserPresent = userRepository.findByEmailId(loginDTO.getEmailId());

	        if (isUserPresent.isPresent()) {
	            String password = isUserPresent.get().getPassword();
	            if (password.equals(loginDTO.getPassword())) {
	                token = tokenUtil.createToken(isUserPresent.get().getUserId());
	                return new Response("User is Found", 300,token);
	            } else throw new GlobalException("Password is Wrong");
	        }
	        else {
	            throw new GlobalException("Email Id or Password is Wrong");
	        }
	    }
	    public Boolean verifyUser(String token) {
	        int id = tokenUtil.decodeToken(token);

	        Optional<User> isUserPresent = userRepository.findById(id);
	        if (isUserPresent.isPresent()) {
	            isUserPresent.get().setVerify(true);
	            userRepository.save(isUserPresent.get());
	            return true;
	        } else {
	            return false;
	        }
	    }
	        @Override
	        public User forgotPassword(String emailId, String password) {
	            Optional<User> isUserPresent = userRepository.findByEmailId(emailId);
	            if (isUserPresent.isPresent()) {
	                isUserPresent.get().setPassword(password);
	                return userRepository.save(isUserPresent.get());
	            } else {
	                throw new GlobalException("Invalid Email");
	            }
	        }

			@Override
			public Response deleteUsersById(int id) {
				// TODO Auto-generated method stub
				return null;
			}

			public Response deleteUser(int id) {
				// TODO Auto-generated method stub
				return null;
			}

			public EmailService getEmailService() {
				return emailService;
			}

			public void setEmailService(EmailService emailService) {
				this.emailService = emailService;
			}
	 }