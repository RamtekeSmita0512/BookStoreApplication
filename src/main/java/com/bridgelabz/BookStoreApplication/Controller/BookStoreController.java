package com.bridgelabz.BookStoreApplication.Controller;

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

import com.bridgelabz.BookStoreApplication.Service.BookService;
import com.bridgelabz.BookStoreApplication.Utility.BookDTO;
import com.bridgelabz.BookStoreApplication.Utility.Response;

@RestController
public class BookStoreController {
	
	  @Autowired
	    private BookService bookService;
	  
	@GetMapping("/Books")
    public ResponseEntity<Response> getAllBooks(){
        Response response = bookService.getAllBooks();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/Books/{id}")
    public ResponseEntity<Response> getBooksById(@PathVariable int id) {
        Response response = bookService.getBooksById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/Books")
    public ResponseEntity<Response> creatBooks(@Valid @RequestBody BookDTO bookDto) {
        Response response = bookService.creatNewBook(bookDto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/Books")
    public ResponseEntity<Response> updateBooks(@PathVariable int id,@Valid @RequestBody BookDTO bookDto) {
        Response response = bookService.updateBook(id,bookDto);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Books/{id}")
    public ResponseEntity<Response> deleteBook(@PathVariable int id) {
        Response response = bookService.deleteBookById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
