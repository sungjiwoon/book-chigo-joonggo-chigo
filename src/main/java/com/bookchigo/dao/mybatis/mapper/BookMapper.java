package com.bookchigo.dao.mybatis.mapper;

import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.Book;

public interface BookMapper {
	
	Book getBookById(int book_id);
	void insertBook(Book book);
	void deleteBook(int book_id);

}
