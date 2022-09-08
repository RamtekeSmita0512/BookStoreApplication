package com.bridgelabz.BookStoreApplication.UserController;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.BookStoreApplication.UserModel.EmailService;
import com.bridgelabz.BookStoreApplication.UserModel.Login;
import com.bridgelabz.BookStoreApplication.UserService.UserService;
import com.bridgelabz.BookStoreApplication.Utility.Response;
import com.bridgelabz.BookStoreApplication.Utility.UserDTO;

@RestController
public class UserController {
	
	 @Autowired
    private UserService userService;
	
   @Autowired
   private EmailService emailService;
   
   @GetMapping("/sendemail")
	public String sendEmail() {
		return emailService.sendEmail();
		
	}
   @Autowired
   private Login login;
   
   @PostMapping("/login")
   public ResponseEntity<Response> checkLogin(@RequestBody Login login){
	   Response response =  new Response("post call success",300, login.checkLogin(login));
       return new ResponseEntity<>(response, HttpStatus.OK);
   }

    @GetMapping("/users")
    public ResponseEntity<Response> getAllUsers() {
        Response response = userService.getAllUsers();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Response> getUserById(@PathVariable int id) {
        Response response = userService.getUsersById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Response> addUser(@Valid @RequestBody UserDTO userDto) {
        Response response = userService.createNewUsers(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Response> updateUser(@Valid @RequestBody UserDTO userDto, @PathVariable int id) {
        Response response = userService.updateUser(id, userDto);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable int id) {
        Response response = userService.deleteUser(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
}
