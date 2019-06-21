package com.transation.dao;

import java.util.List;

import com.transation.model.Student;

public interface StudentDao {

	public void insert(Student student);
	public void update(Student student);
	public Student getStudent(int id);
	
	public List<Student> getList();
}
