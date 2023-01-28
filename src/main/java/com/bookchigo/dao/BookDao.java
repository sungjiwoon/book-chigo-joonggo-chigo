package com.bookchigo.dao;

import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.Book;

public interface BookDao {
	
	Book getBookById(int book_id) throws DataAccessException; 
	
	void insertBook(Book book) throws DataAccessException;
	void deleteBook(int book_id) throws DataAccessException;

}
