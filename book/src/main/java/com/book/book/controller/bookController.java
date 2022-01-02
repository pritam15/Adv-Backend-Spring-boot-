package com.book.book.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.book.models.Book;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.book.book.models.Book;
import com.book.book.services.BookServices;

@RestController
@RequestMapping("/book")
public class bookController {

	@Autowired
	private BookServices bookService;

	@PostMapping(value = "/insert")
	public Book create(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@GetMapping(value = "/allBooks")
	public List<Book> retrivebookList() {
		return bookService.getBookList();
	}
	
	@GetMapping(value = "/Author")
	public List<Book> retrieveBookByAuthor(@PathParam("authorName") String authorName) {
		return bookService.findBookByAuthorName(authorName);
	}

	@GetMapping(value = "/BookName")
	public List<Book> retrieveBookByBookName(@PathParam("bookName") String bookName) {
		return bookService.findBookByBookName(bookName);
	}

	@PutMapping(value = "/updateByBookName")
	public Book updateBookByName(@PathParam("bookName") String bookName) {
		return bookService.updateBookByName(bookName);
	}
	
	@PutMapping(value = "/updateByAuthorName")
	public Book updateBookByAuthorName(@PathParam("id") Integer id, @PathParam("authorName") String authorName) {
		return bookService.updateBookByAuthorName(id, authorName);
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<Book> deleteBookByName(@PathParam("bookName") String bookName) {
		if(bookService.deleteBookByName(bookName)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
