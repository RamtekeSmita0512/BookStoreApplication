package com.bridgelabz.BookStoreApplication;



import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;






@SpringBootApplication
public class SpringBookStoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookStoreAppApplication.class, args);
	System.out.println("Welcome BookStore App");
   }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
	
