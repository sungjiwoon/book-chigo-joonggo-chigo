package com.bookchigo.domain;

import java.io.Serializable;

public class Book implements Serializable {
	
	private int book_id; // ISBN
	private String book_name;
	private String book_writer; 
	private String book_publisher; 
	private int book_price;
	private String book_summary;
	private String book_photo; 
	
	public Book() {}
	
	public Book(int book_id, String book_name, String book_writer, String book_publisher, int book_price,
			String book_summary, String book_photo) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_writer = book_writer;
		this.book_publisher = book_publisher;
		this.book_price = book_price;
		this.book_summary = book_summary;
		this.book_photo = book_photo;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public String getBook_summary() {
		return book_summary;
	}
	public void setBook_summary(String book_summary) {
		this.book_summary = book_summary;
	}
	public String getBook_photo() {
		return book_photo;
	}
	public void setBook_photo(String book_photo) {
		this.book_photo = book_photo;
	}
	
}
