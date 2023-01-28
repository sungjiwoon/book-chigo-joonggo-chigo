package com.bookchigo.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.bookchigo.dao.BookDao;
import com.bookchigo.dao.mybatis.mapper.BookMapper;
import com.bookchigo.dao.mybatis.mapper.GroupPurchaseMapper;
import com.bookchigo.domain.Book;

@Repository
public class MyBatisBookDao implements BookDao {
	
	@Autowired
	private BookMapper bookMapper;
	
	public Book getBookById(int book_id) throws DataAccessException {
		return bookMapper.getBookById(book_id);
	}; 
	
	public void insertBook(Book book) throws DataAccessException {
		bookMapper.insertBook(book);
	}

	public void deleteBook(int book_id) throws DataAccessException {
		bookMapper.deleteBook(book_id);
	}; 

}
