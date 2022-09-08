package com.bridgelabz.BookStoreApplication.UserRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.BookStoreApplication.UserModel.Registration;
import com.bridgelabz.BookStoreApplication.UserModel.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	static Registration findByUserName(Object userName) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
