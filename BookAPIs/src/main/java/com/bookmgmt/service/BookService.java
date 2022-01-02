package com.bookmgmt.service;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookmgmt.model.Book;

@Service
public class BookService {
	
	private List<Book> bookList = new ArrayList<>();
	
	public BookService() {
		bookList.add(new Book(1, "Fiction-Mystery", "Arthur Conan Doyle", "The Adventures of Sherlock Holmes", "Penguin Classics"));
		bookList.add(new Book(2, "Romance", "Jane Austen", "Pride & Prejudice", "Penguin Classics"));
		bookList.add(new Book(3, "Self Help", "Marcus Aurelius", "Meditations", "Bookbind Publications"));
		bookList.add(new Book(4, "Mythology", "Shri Krishna", "Bhagvat Gita", "Gita Prakashan"));
		bookList.add(new Book(5, "Politics", "Chanakya", "Chanakya Neeti Sutra", "Bharat Publishing Company"));
		bookList.add(new Book(6, "Politics-Economics", "Chanakya", "Chanakya's Arthashastra", "Bharat Publishing Company"));
	}
	
	
	
	public List<Book> getBookList() {
		return bookList;
	}



	public Book addBook(Book book) {
		bookList.add(book);
		return book;
	}



	public List<Book> findBookByAuthorName(String authorName) {
		List<Book> authorBooks = new ArrayList<>();
		authorBooks = bookList.stream()
								.filter(book -> book.getAuthor().equals(authorName))
								.collect(Collectors.toList());
		return authorBooks;
	}



	public List<Book> findBookByBookName(String bookName) {
		List<Book> booksList = new ArrayList<>();
		booksList = bookList.stream()
							.filter(book -> book.getName().equals(bookName))
							.collect(Collectors.toList());
		return booksList;
	}



	public Book updateBookByName(Integer id, String bookName) {
		Book updatedBook = new Book();
		for(Book book : bookList) {
			if(book.getBookId() == id) {
				book.setName(bookName);
				updatedBook = book;
				break;
			}
		}
		
		return updatedBook;
	}



	public Book updateBookByAuthorName(Integer id, String authorName) {
		Book updatedBook = new Book();
		for(Book book : bookList) {
			if(book.getBookId() == id) {
				book.setAuthor(authorName);
				updatedBook = book;
				break;
			}
		}
		
		return updatedBook;	
	}



	public boolean deleteBookByName(String bookName) {
		for(Book book : bookList) {
			if(book.getName().equals(bookName)) {
				bookList.remove(book);
				return true;
			}
		}
		return false;
	}
}
