package com.bridgelabz.BookStoreApplication.user.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.BookStoreApplication.user.model.User;
import com.bridgelabz.BookStoreApplication.user.service.UserService;
import com.bridgelabz.BookStoreApplication.user.util.EmailService;
import com.bridgelabz.BookStoreApplication.utility.LoginDTO;
import com.bridgelabz.BookStoreApplication.utility.RegistrationDTO;
import com.bridgelabz.BookStoreApplication.utility.Response;
import com.bridgelabz.BookStoreApplication.utility.UserDTO;

@RestController
@RequestMapping("/userregistration")
public class UserController {
	
	 @Autowired
    private UserService userService;
	
   @Autowired
   private EmailService emailService;
   
    
   
   @GetMapping("/sendemail")
	public String sendEmail() {
		return emailService.sendEmail();
		
	}
  
   
    @PostMapping("/login")
   public ResponseEntity<Response> loginUser(@RequestBody LoginDTO loginDTO) {
       Response response = userService.loginValidation(loginDTO);
       return new ResponseEntity<Response>(response, HttpStatus.OK);
   }

   @PostMapping("/user/verify/{token}")
   public ResponseEntity<Response> loginVerify(@PathVariable("token")String token) {
       Boolean result = userService.verifyUser(token);
       Response response = new Response("User Successfully Verified", 400,"Verification Status : "+ result);
       return new ResponseEntity<Response>(response, HttpStatus.OK);
   }

   @PostMapping("/forgotpassword")
   public ResponseEntity<Response> forgotPassword(@RequestParam String emailId,
                                                     @RequestParam String password) {
       User userData = userService.forgotPassword(emailId, password);
       Response response = new Response("Password Updated Successfully", 400,userData);
       emailService.sendEmail(userData.getEmailId(), "Password Recovered Successfully.",
               "Dear " + userData.getFirstName() + ", You have Successfully recovered password of book store.");
       return new ResponseEntity<Response> (response, HttpStatus.OK);
   }

   @GetMapping("/getallusers")
   public ResponseEntity<Response> getALlUsers(@RequestBody RegistrationDTO registration){
       Response response =  new Response("Get call is success", 300,registration.getAllUser());
       return new ResponseEntity<>(response, HttpStatus.OK);
   }

   
   @PostMapping("/adduser")
   public ResponseEntity<Response> addUser(@RequestBody RegistrationDTO registration){
       Response response = new  Response("Post call success",300, registration.addUser(registration));
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

	
}
