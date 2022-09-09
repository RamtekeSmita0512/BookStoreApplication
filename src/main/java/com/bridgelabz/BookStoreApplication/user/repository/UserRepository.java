package com.bridgelabz.BookStoreApplication.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.BookStoreApplication.user.model.User;
import com.bridgelabz.BookStoreApplication.utility.RegistrationDTO;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//Optional<RegistrationDTO> findByEmailId(String emailId);

	//RegistrationDTO save(RegistrationDTO registrationDTO);

	public Optional<User> findByEmailId(String emailId);
	

}
