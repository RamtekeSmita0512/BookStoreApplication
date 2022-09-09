package com.bridgelabz.BookStoreApplication.book.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.BookStoreApplication.book.service.BookService;
import com.bridgelabz.BookStoreApplication.utility.BookDTO;
import com.bridgelabz.BookStoreApplication.utility.Response;

@RestController

public class BookStoreController {
	
	  @Autowired
	    private BookService bookService;

	  
	@GetMapping("/books")
    public ResponseEntity<Response> getAllBooks(){
        Response response = bookService.getAllBooks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Response> getBooksById(@PathVariable int id) {
        Response response = bookService.getBooksById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/addbooks")
    public ResponseEntity<Response> createBooks(@Valid @RequestBody BookDTO bookDto) {
        Response response = bookService.createNewBook(bookDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/updatebooks")
    public ResponseEntity<Response> updateBooks(@PathVariable int id,@Valid @RequestBody BookDTO bookDto) {
        Response response = bookService.updateBook(id,bookDto);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Response> deleteBook(@PathVariable int id) {
        Response response = bookService.deleteBookById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
