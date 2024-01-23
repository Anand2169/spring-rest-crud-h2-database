package com.bigil.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bigil.entity.Book;
import com.bigil.repository.BookRepository;

@Service
public class BookServiceImpl implements BookServiceRepository {

	private BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {

		this.bookRepository = bookRepository;
	}

	@Override
	public String upsertBook(Book book) {

		Integer bookId = book.getBookId(); // bookId = null
		
		bookRepository.save(book);
		
		if (bookId == null) {
			
			return "Record inserted successfully...";

		} else {
			
			return "Record updated successfully...";
		}
		
	}

	@Override
	public List<Book> getAllBooks() {

		return bookRepository.findAll(); // findAll() method returning List of Objects/elements
	}

	@Override
	public String deleteBook(Integer bookId) {
		bookRepository.deleteById(bookId);

		return "Book deleted successfully";
	}

}
