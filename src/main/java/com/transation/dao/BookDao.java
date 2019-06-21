package com.transation.dao;

import java.util.List;

import com.transation.model.Book;

public interface BookDao {

	public void insert(Book book);
	public void delete(int id);
	public void update(Book book);
	public Book getBook(int id);
	
	public List<Book> getList();
}
