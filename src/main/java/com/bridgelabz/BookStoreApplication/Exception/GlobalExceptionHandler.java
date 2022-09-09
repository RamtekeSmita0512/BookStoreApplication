package com.bridgelabz.BookStoreApplication.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.BookStoreApplication.utility.Response;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(GlobalException.class)
	    public ResponseEntity<Response> handleNonExistingID(GlobalException exception) {
	        Response response = new Response("Exception while parsing Rest request",200, exception.getMessage());
	        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	    }
	 
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
	        List<ObjectError> errorObjectList = exception.getBindingResult().getAllErrors();
	        List<String> errorMessage = errorObjectList.stream()
	                .map(objErr -> objErr.getDefaultMessage())
	                .collect(Collectors.toList());
	        Response response = new Response("Exception while parsing Rest request",200,errorMessage);
	        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
	    }

}
