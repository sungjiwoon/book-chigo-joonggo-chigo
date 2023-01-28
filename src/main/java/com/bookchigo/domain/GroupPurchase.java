package com.bookchigo.domain;
import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class GroupPurchase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int gp_postId;
	private int book_id;
	private String post_title; 
	private String post_contents; 
	private int readerMemberId; // 우리가 디비에서 부여하는 고유번호 memeberID 
	
	@DateTimeFormat (pattern ="yyyy-MM-dd")
	private Date gp_date; 
	
	private int ing; 
  	private int limit; 
	private int now;
	private String account; 
	private int dis_price; 
	private String readerId; // 가입 시 사용자가 입력하는 아이디(겹칠수있다)
	private String book_photo;
	
	public GroupPurchase() {}
	
	
	
	public GroupPurchase(String post_title, String post_contents, Date date, int limit, int dis_price, int gp_postId) {
		super();
		this.post_title = post_title;
		this.post_contents = post_contents;
		this.gp_date = date;
		this.limit = limit;
		this.dis_price = dis_price;
		this.gp_postId = gp_postId;
	}



	public GroupPurchase(int book_id, String post_title, String post_contents, int readerMemberId, Date date, int ing,
			int limit, int now, String account, int dis_price, String readerId) {
		super();
		this.book_id = book_id;
		this.post_title = post_title;
		this.post_contents = post_contents;
		this.readerMemberId = readerMemberId;
		this.gp_date = date;
		this.ing = ing;
		this.limit = limit;
		this.now = now;
		this.account = account;
		this.dis_price = dis_price;
		this.readerId = readerId;
	}

	
	public GroupPurchase(int book_id, String post_title, String post_contents, int readerMemberId,
			Date date, int ing, int limit, int now, String account, int dis_price, String readerId, String book_photo) {
		super();
		this.book_id = book_id;
		this.post_title = post_title;
		this.post_contents = post_contents;
		this.readerMemberId = readerMemberId;
		this.gp_date = date;
		this.ing = ing;
		this.limit = limit;
		this.now = now;
		this.account = account;
		this.dis_price = dis_price;
		this.readerId = readerId;
		this.book_photo = book_photo;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getGp_postId() {
		return gp_postId;
	}

	public void setGp_postId(int gp_postId) {
		this.gp_postId = gp_postId;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public String getPost_contents() {
		return post_contents;
	}

	public void setPost_contents(String post_contents) {
		this.post_contents = post_contents;
	}

	public int getReaderMemberId() {
		return readerMemberId;
	}

	public void setReaderMemberId(int readerMemberId) {
		this.readerMemberId = readerMemberId;
	}
	


	public Date getGp_date() {
		return gp_date;
	}


	public void setGp_date(Date gp_date) {
		this.gp_date = gp_date;
	}

	public int getIng() {
		return ing;
	}

	public void setIng(int ing) {
		this.ing = ing;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getNow() {
		return now;
	}

	public void setNow(int now) {
		this.now = now;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getDis_price() {
		return dis_price;
	}

	public void setDis_price(int discount_price) {
		this.dis_price = discount_price;
	}
	
	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}
	
	public String getReaderId() {
		return readerId;
	}

	public String getBook_photo() {
		return book_photo;
	}

	public void setBook_photo(String book_photo) {
		this.book_photo = book_photo;
	}
	


}
