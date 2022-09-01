package com.bridgelabz.BookStoreApplication.Utility;



import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
	
    @NotBlank(message = "Book name should not null")
    public String bookName;

    @NotBlank(message = "Author name should not null")
    public String authorName;

    @NotBlank(message = "Price should not null")
    public float price;

    @NotBlank(message = "Quantity should not null")
    public float quantity;

}