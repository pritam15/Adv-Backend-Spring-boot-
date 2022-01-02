package com.book.book.services;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.book.book.models.Book;
@Service
public class BookServices {
	
private List<Book> bookList = new ArrayList<>();
	
	public BookServices() {
		bookList.add(new Book( "The Psychology of Money ", "Arthur Morgan Housel", "Anlysis & Strategy", "Jaico Publishing House"));
		bookList.add(new Book("Rich Dad Poor Dad","Author Robert T. Kiyosaki", " Family & Relationship", " Plata Publishing"));
		bookList.add(new Book("Atomic Habbits", " Author James Clear"," Healthy Living & Wellness", " Random House Business Books"));
		bookList.add(new Book("Deep Work","Author Cal Newport","Personal Transformation","Little, Brown Book Group"));
		bookList.add(new Book("The 5 AM Club", "Author Robin Sharma","Self Helped","Jaico Publishing House"));
		bookList.add(new Book("Life's Amazing Secrets", "Author Gaur Gopal Das", "Personal Transformation"," Penguin Ananda "));
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
								.filter(book -> book.getBookAuthor().equals(authorName))
								.collect(Collectors.toList());
		return authorBooks;
	}



	public List<Book> findBookByBookName(String bookName) {
		List<Book> booksList = new ArrayList<>();
		booksList = bookList.stream()
							.filter(book -> book.getBookName().equals(bookName))
							.collect(Collectors.toList());
		return booksList;
	}



	public Book updateBookByName(String bookName) {
		Book updatedBook = new Book();
		for(Book book : bookList) {
				book.setBookName(bookName);
				updatedBook = book;
				break;
			}
		return updatedBook;
	}



	public Book updateBookByAuthorName(Integer id, String authorName) {
		Book updatedBook = new Book();
		for(Book book : bookList) {
				book.setBookAuthor(authorName);
				updatedBook = book;
				break;
			}
		
		return updatedBook;	
	}



	public boolean deleteBookByName(String bookName) {
		for(Book book : bookList) {
			if(book.getBookName().equals(bookName)) {
				bookList.remove(book);
				return true;
			}
		}
		return false;
	}
}
