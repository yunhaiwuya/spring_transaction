package com.transation.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.transation.model.Book;

public class BookDaoImp extends JdbcDaoSupport implements BookDao{

	@Override
	public void insert(Book book) {
		String sql = "insert into book(name,number) value (?,?)";
		this.getJdbcTemplate().update(sql, book.getName(),book.getNumber());
	}

	@Override
	public void delete(int id) {
		String sql = "delete from book where id = ?";
		this.getJdbcTemplate().update(sql, id);
	}

	@Override
	public void update(Book book) {
		String sql = "update book set number = ? where book_id = ?";
		this.getJdbcTemplate().update(sql, book.getName(),book.getNumber(),book.getBook_id());
		System.out.println("book修改一条记录");
	}

	@Override
	public Book getBook(int id) {
		String sql = "select book_id,name,number from book where id = ?";
		RowMapper<Book> rowMapper = new BeanPropertyRowMapper<Book>(Book.class);
		return this.getJdbcTemplate().queryForObject(sql, rowMapper,id);
	}

	@Override
	@SuppressWarnings({"unchecked","rawtypes"})
	public List<Book> getList() {
		String sql = "select * from book";
		List<Book> list = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Book.class));
		return list;
	}

}
