package com.bigil.rest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bigil.entity.Book;
import com.bigil.service.BookServiceRepository;

@RestController
@CrossOrigin
public class BookRestController {

	BookServiceRepository bookServiceRepository;

	public BookRestController(BookServiceRepository bookServiceRepository) {
		this.bookServiceRepository = bookServiceRepository;
	}

	@PostMapping(
			      value = "/book",
			      consumes = {"application/xml","application/json"},
			      produces = {"application/json","application/xml"}			     
			    )
	public ResponseEntity<String> addBook(@RequestBody Book book) {

		String upsertBook = bookServiceRepository.upsertBook(book);
		return new ResponseEntity<String>(upsertBook, HttpStatus.CREATED);
	}
	
	@PutMapping(
		      value = "/book",
		      consumes = {"application/json","application/xml"},
		      produces = {"application/json","application/xml"}			     
		    )
    public ResponseEntity<String> updateBook(@RequestBody Book book) {

	       String upsertBook = bookServiceRepository.upsertBook(book);
	       return new ResponseEntity<String>(upsertBook, HttpStatus.CREATED);
   }
	
	@GetMapping(value =  "/books",
		       produces = {"application/json","application/xml"}
			)
	public ResponseEntity<List<Book>> getAllBooks(){
		
		List<Book> allBooks = bookServiceRepository.getAllBooks();
		
		return new ResponseEntity<List<Book>>(allBooks, HttpStatus.OK);
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<String> deleteRecord(@PathVariable Integer bookId){
		
		String deleteBook = bookServiceRepository.deleteBook(bookId);
		
		return new ResponseEntity<String>(deleteBook, HttpStatus.OK);
	}

}
