package com.transation.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.transation.model.Student;

public class StudentJdbcDaoSupportDaoImp extends JdbcDaoSupport implements StudentDao {

	@Override
	public void insert(Student student) {
		String sql = "insert into student(name,sex,age)"+
					 " values(?,?,?)";
		this.getJdbcTemplate().update(sql, new Object[]{student.getName(),
				student.getSex(),student.getAge()});
		System.out.println("插入一条记录");
	}
	//批量插入
	public void insertBatch(final List<Student> students){
		String sql = "insert into student(name,sex,age)"+
				 " values(?,?,?)";
		this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps, int i)
					throws SQLException {
				Student student = students.get(i);
				ps.setString(1, student.getName());
				ps.setString(2, student.getSex());
				ps.setInt(3, student.getAge());
			}

			@Override
			public int getBatchSize() {
				return students.size();
			}
		});
		System.out.println("批量插入"+students.size()+"条记录");
	}
	@Override
	public Student getStudent(int id) {
		String sql = "select id,name,sex,age from student where id = ?";
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		return this.getJdbcTemplate().queryForObject(sql, rowMapper,id);
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Student> getList() {
		String sql = "select * from student";
		List<Student> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Student.class));
		return list;
	}
	@Override
	public void update(Student student) {
		String sql = "update student set money = ? where id = ?";
		this.getJdbcTemplate().update(sql, student.getMoney(),student.getId());
		System.out.println("student修改一条记录");
	}
}
