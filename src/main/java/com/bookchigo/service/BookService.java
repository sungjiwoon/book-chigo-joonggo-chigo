package com.bookchigo.service;

import org.springframework.dao.DataAccessException;

import com.bookchigo.domain.Book;

public interface BookService {
	
	public Book getBookById(int book_id); 
	
	public void insertBook(Book book);
	public void deleteBook(int book_id);

}
