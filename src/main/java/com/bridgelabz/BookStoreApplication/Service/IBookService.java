package com.bridgelabz.BookStoreApplication.Service;

import com.bridgelabz.BookStoreApplication.Utility.BookDTO;
import com.bridgelabz.BookStoreApplication.Utility.Response;

public interface IBookService {

	 //getAll
    Response getAllBooks();
    //get
    Response getBooksById(Integer id);
    //getByName
    Response getBooksByName(String bookName);
    //post
    Response createNewBook(BookDTO bookDto);
    //update
    Response updateBook(int id, BookDTO bookDto);
    //delete
    Response deleteBookById(int id);
    //deleteByName
  
   Response deleteBooksByName(BookDTO bookDto);


}
