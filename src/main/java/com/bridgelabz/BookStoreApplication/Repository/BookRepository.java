package com.bridgelabz.BookStoreApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.BookStoreApplication.Model.BookStore;

@Repository
public interface BookRepository extends JpaRepository<BookStore, String>{

	BookStore findByBookName(String bookName);
    BookStore deleteById(int id);
	List<BookStore> findById(Integer id);


}
