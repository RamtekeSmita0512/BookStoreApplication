package com.bridgelabz.BookStoreApplication.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.BookStoreApplication.Model.BookStore;
import com.bridgelabz.BookStoreApplication.Repository.BookRepository;
import com.bridgelabz.BookStoreApplication.Utility.BookDTO;
import com.bridgelabz.BookStoreApplication.Utility.Response;

@Service
public class BookService implements IBookService{
	
	
	  @Autowired
	    private BookRepository bookRepository;
	    @Autowired
	    private ModelMapper modelMapper;
	    @Autowired
	    private Response response;
	    
	    	    @Override
	    public Response getAllBooks() {
	        return new Response("All books get Succefully",100,bookRepository.findAll());
	    }

	    @Override
	    public Response getBooksById(Integer id) {
	        return new Response("Get book by id",100,bookRepository.findById(id));
	    }

	    
		@Override
	    public Response getBooksByName(String bookName) {
	        return new Response("Get by name succefully",100,bookRepository.findByBookName(bookName));
	    }

	    @Override
	    public Response createNewBook(BookDTO bookDto) {
	        BookStore bookStore = modelMapper.map(bookDto,BookStore.class);
	        bookRepository.save(bookStore);
	        System.out.println(bookStore.toString());
	        return new Response("Book adding succefully..",100,bookStore);
	    }

	    @Override
	    public Response updateBook(int id, BookDTO bookStoreDataDto) {
	        BookStore bookStore = modelMapper.map(bookStoreDataDto,BookStore.class);
	        bookRepository.save(bookStore);
	        return new Response("Update new book",100,bookStore);
	    }

	    @Override
	    public Response deleteBookById(int id) {
	        return new Response("Delete book information",100, bookRepository.deleteById(id));
	    }

	    @Override
	    public Response deleteBooksByName(BookDTO bookDto) {
	        return null;
	    }

		public Response getResponse() {
			return response;
		}

		public void setResponse(Response response) {
			this.response = response;
		}

		public Integer getBookList() {
			// TODO Auto-generated method stub
			return null;
		}

}