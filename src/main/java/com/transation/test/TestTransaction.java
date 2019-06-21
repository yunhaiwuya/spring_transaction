package com.transation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.transation.exception.BuyBookException;
import com.transation.model.Book;
import com.transation.model.Student;
import com.transation.service.BuyBookService;

public class TestTransaction {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BuyBookService buyBook = (BuyBookService)context.getBean("buyBookService");
		Student student = new Student(1,100);
		Book book = new Book(1001,10);
		try {
			buyBook.buyBook(student, book);
		} catch (BuyBookException e) {
			e.printStackTrace();
		}

	}

}
