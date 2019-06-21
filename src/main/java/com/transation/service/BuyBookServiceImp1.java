package com.transation.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transation.dao.BookDao;
import com.transation.dao.StudentDao;
import com.transation.exception.BuyBookException;
import com.transation.model.Book;
import com.transation.model.Student;

public class BuyBookServiceImp1 implements BuyBookService {

	private StudentDao studentDao;
	private BookDao bookDao;
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void addStudent(Student student) {
		studentDao.insert(student);
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public void addBook(Book book) {
		bookDao.insert(book);
	}

	@SuppressWarnings("unused")
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=BuyBookException.class)
	@Override
	public void buyBook(Student student, Book book) throws BuyBookException {
		boolean isBuy = true;
		studentDao.update(student);
		if(isBuy=true){
			throw new BuyBookException("购买图书发生异常");
		} 
		bookDao.update(book);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
