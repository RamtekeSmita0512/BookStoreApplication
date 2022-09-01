package com.bridgelabz.BookStoreApplication.Configuration;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfiguration {
	
	

	    @Bean
	     Docket booksApi() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	                .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.BookStoreApplication.Configuration")).build();
	    }

}
