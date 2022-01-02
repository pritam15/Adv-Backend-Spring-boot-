package com.bookmgmt.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.bookmgmt.model.Book;
import com.bookmgmt.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/insert",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Book create(@RequestBody Book book) {
		return bookService.addBook(book);
	}

	@GetMapping(value = "/retrieveByAuthor", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> retrieveBookByAuthor(@PathParam("authorName") String authorName) {
		return bookService.findBookByAuthorName(authorName);
	}

	@GetMapping(value = "/retrieveByBookName", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> retrieveBookByBookName(@PathParam("bookName") String bookName) {
		return bookService.findBookByBookName(bookName);
	}

	@PutMapping(value = "/updateByBookName",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBookByName(@PathParam("id") Integer id, @PathParam("bookName") String bookName) {
		return bookService.updateBookByName(id, bookName);
	}
	
	@PutMapping(value = "/updateByAuthorName",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Book updateBookByAuthorName(@PathParam("id") Integer id, @PathParam("authorName") String authorName) {
		return bookService.updateBookByAuthorName(id, authorName);
	}
	
	@DeleteMapping(value = "/delete",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> deleteBookByName(@PathParam("bookName") String bookName) {
		if(bookService.deleteBookByName(bookName)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAllBooks() {
		return bookService.getBookList();
	}
}
