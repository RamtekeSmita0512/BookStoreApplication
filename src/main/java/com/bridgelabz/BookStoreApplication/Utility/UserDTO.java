package com.bridgelabz.BookStoreApplication.Utility;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@ToString
@Getter
@Setter
//@ToString
@AllArgsConstructor
@NoArgsConstructor

	
public class UserDTO {
	

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "User Name = User name Invalid please follow guideline")
    private String name;

    @Pattern(regexp = "^[7-9]{1}[1-9]{9}" , message = "Please inter valid Phone number")
    private String phoneNumber;

    @NotBlank(message = "Address filling is mandatory.")
    private String address;

    @NotNull
   @Pattern(regexp = "^[1-9]{6}$" , message = "Pincode is only 6 digit..")
    private String pinCode;
}