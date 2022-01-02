package com.bookmgmt.model;

public class Book {
	
	private Integer bookId;
	private String category;
	private String author;
	private String name;
	private String publisher;
	
	public Book() {
		
	}
	
	public Book(Integer bookId, String category, String author, String name, String publisher) {
		this.bookId = bookId;
		this.category = category;
		this.author = author;
		this.name = name;
		this.publisher = publisher;
	}
	
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
