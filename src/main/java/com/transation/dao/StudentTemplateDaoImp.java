package com.transation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.transation.model.Student;

public class StudentTemplateDaoImp implements StudentDao {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Student student) {
		String sql = "insert into student(name,sex,age)"+
					 " values(?,?,?)";

		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[]{student.getName(),
				student.getSex(),student.getAge()});
	}

	@Override
	public Student getStudent(int id) {
		String sql = "select id,name,sex,age from student where id = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		return jdbcTemplate.queryForObject(sql, rowMapper,id);
	}

	@Override
	@SuppressWarnings({"unchecked","rawtypes"})
	public List<Student> getList() {
		String sql = "select id,name,sex,age from student";
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));
		return list;
	}

	@Override
	public void update(Student student) {
		String sql = "update student set money = ? where id = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, student.getMoney(),student.getId());
	}
}
