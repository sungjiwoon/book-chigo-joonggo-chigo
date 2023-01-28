package com.bookchigo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookchigo.dao.BookDao;
import com.bookchigo.dao.GroupPurchaseDao;
import com.bookchigo.domain.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public Book getBookById(int book_id) {
		return bookDao.getBookById(book_id);
	}

	@Override
	public void insertBook(Book book) {
		bookDao.insertBook(book);
	}

	@Override
	public void deleteBook(int book_id) {
		bookDao.deleteBook(book_id);	
	}
}
