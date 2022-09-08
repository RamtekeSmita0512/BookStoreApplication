package com.bridgelabz.BookStoreApplication.Utility;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

	
public class UserDTO {
	

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "User Name = User name Invalid please follow guideline")
    private String name;

    @Pattern(regexp = "^[0-9]{1}[0-9]{9}$" , message = "Please inter valid Phone number")
    private String phoneNumber;

    @NotBlank(message = "Address filling is mandatory.")
    private String address;

  
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Enter proper city name")
    private String city;
      
   @Pattern(regexp = "^[0-9]{6}$" , message = "Pincode is only 6 digit..")
    private String pinCode;

public Object userName;

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

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

}
