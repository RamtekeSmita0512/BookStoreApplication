package com.bridgelabz.BookStoreApplication.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.BookStoreApplication.book.model.BookStore;

@Repository
public interface BookRepository extends JpaRepository<BookStore, String>{

	BookStore findByBookName(String bookName);
    BookStore deleteById(int id);
	List<BookStore> findById(Integer id);


}
