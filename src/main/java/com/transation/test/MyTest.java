package com.transation.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.transation.dao.StudentJdbcDaoSupportDaoImp;
import com.transation.model.HelloWorld;
import com.transation.model.Student;

public class MyTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld hw = (HelloWorld)context.getBean("helloWorld");
		hw.printHello();
		/*StudentDao studentDao = (StudentDao)context.getBean("studentDao");*/
		/*Student student = studentDao.getStudent(6);
		System.out.println(student.getName());
		List<Student> list = studentDao.getList();
		System.out.println(list.size());*/
		List<Student> list = new ArrayList<Student>();
		Student student1 = new Student("xiaowu1","1",20);
		Student student2 = new Student("xiaowu2","1",20);
		Student student3 = new Student("xiaowu3","1",20);
		list.add(student1);
		list.add(student2);
		list.add(student3);
		StudentJdbcDaoSupportDaoImp studentDao = (StudentJdbcDaoSupportDaoImp)context.getBean("studentDao");
		studentDao.insertBatch(list);
	}

}
