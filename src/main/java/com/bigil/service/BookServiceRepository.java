package com.bigil.service;

import java.util.List;

import com.bigil.entity.Book;

public interface BookServiceRepository {

	// both create and update operations
	String upsertBook(Book book);
	
	// retrieve all data
	List<Book> getAllBooks();

	// update data
//	String updateBook(Book book);

	// delete Data
	String deleteBook(Integer bookId);

}
