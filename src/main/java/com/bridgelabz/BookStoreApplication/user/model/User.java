package com.bridgelabz.BookStoreApplication.user.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User  {

	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO )
	    private int id;
	    private String name;
	    private String phoneNumber;
	    private String address;
	    private String city;
	    private String pinCode;
	    private String emailId;

	    @OneToOne(cascade = CascadeType.ALL , mappedBy = "user")
	    private Cart cart;

	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getPinCode() {
			return pinCode;
		}
		public void setPinCode(String pinCode) {
			this.pinCode = pinCode;
		}
		public void setVerify(boolean b) {
			// TODO Auto-generated method stub
			
		}
		public Object getEmailId() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getFirstName() {
			// TODO Auto-generated method stub
			return null;
		}
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
		public int getUserId() {
			// TODO Auto-generated method stub
			return 0;
		}
		public void setPassword(String password) {
			// TODO Auto-generated method stub
			
		}

	
}
