package com.book.book.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
	private String bookName;
	private String bookAuthor;
	private String bookCategory;
	private String publisher;
	
	public Book(String bookName, String bookAuthor, String bookCategory, String publisher) {
		super();
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookCategory = bookCategory;
		this.publisher = publisher;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookCategory=" + bookCategory
				+ ", publisher=" + publisher + "]";
	}

	
	

}
