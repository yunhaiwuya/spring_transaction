package com.transation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.transation.model.Student;

public class StudentDaoImp implements StudentDao {

	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Student student) {
		String sql = "insert into student(name,sex,age)"+
					 " values(?,?,?)";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			////参数索引是从1开始计算,
			ps.setString(1, student.getName());
			ps.setString(2, student.getSex());
			ps.setInt(3, student.getAge());
			//INSERT、UPDATE 或 DELETE 语句的效果是修改表中零行或多行中的一列或多列。
			//executeUpdate 的返回值是一个整数，指示受影响的行数（即更新计数）。
			int s = ps.executeUpdate();
			System.out.println("插入一行记录："+s);
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		}
	}

	@Override
	public Student getStudent(int id) {
		String sql = "select id,name,sex,age from student where id = ?";
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			Student student = null;
			ResultSet rs = ps.executeQuery();
			System.out.println("获取一条记录");
			if(rs.next()){
				student = new Student();
				student.setId(id);
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getInt("age"));
			}
			rs.close();
			ps.close();
			return student;
		} catch (SQLException e) {
			throw new RuntimeException();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public List<Student> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		
	}
}
