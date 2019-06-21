package com.transation.service;

import com.transation.exception.BuyBookException;
import com.transation.model.Book;
import com.transation.model.Student;

public interface BuyBookService {

	public void addStudent(Student student);
	public void addBook(Book book);
	public void buyBook(Student student,Book book) throws BuyBookException;
}
