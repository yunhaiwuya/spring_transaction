package com.transation.model;

public class Book {

	private int book_id;
	private String name;
	private int number;
	
	public Book() {
		super();
	}
	
	public Book(int book_id, int number) {
		super();
		this.book_id = book_id;
		this.number = number;
	}

	public Book(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
