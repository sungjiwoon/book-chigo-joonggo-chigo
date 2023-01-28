package com.bookchigo.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AuctionItem  {
	private int au_itemId; //: 경매 게시글 아이디 (시퀀스 사용)
	private int memberId; // : 판매자 아이디
	private String itemname; // : 경매 책 제목
	private String author; //: 경매 책 작가
	private String publisher; // : 경매 책 출판사 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline; // : 경매 마감일 (Date)
	private String imageurl; // : 경매 책 이미지 경로
	private String condition;
	private int dealstatus; // : 경매 거래 상태
	//(0 : 입찰 상태  1 : 낙찰 확정  2 : 낙찰 실패 3: 낙찰 진행 중  4: 낙찰 포기 )
	private int startprice; // : 희망 시작 가격
	private int finalprice; //: 최종 거래 가격 
	private int au_bidId; //: 입찰 Id
	private int au_memberId; // : 입찰자 id 
	private String account;
	public int getAu_itemId() {
		return au_itemId;
	}
	public void setAu_itemId(int au_itemId) {
		this.au_itemId = au_itemId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public int getDealstatus() {
		return dealstatus;
	}
	public void setDealstatus(int dealstatus) {
		this.dealstatus = dealstatus;
	}
	public int getStartprice() {
		return startprice;
	}
	public void setStartprice(int startprice) {
		this.startprice = startprice;
	}
	public int getFinalprice() {
		return finalprice;
	}
	public void setFinalprice(int finalprice) {
		this.finalprice = finalprice;
	}
	public int getAu_bidId() {
		return au_bidId;
	}
	public void setAu_bidId(int au_bidId) {
		this.au_bidId = au_bidId;
	}
	public int getAu_memberId() {
		return au_memberId;
	}
	public void setAu_memberId(int au_memberId) {
		this.au_memberId = au_memberId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}

	
	
}
