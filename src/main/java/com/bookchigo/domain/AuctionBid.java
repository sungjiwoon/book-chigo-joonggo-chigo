package com.bookchigo.domain;

import java.io.Serializable;
import java.util.Date;

public class AuctionBid {
	
	private int au_bidId; //: 입찰 Id
	private int au_itemId; //: 경매 게시글 아이디 (시퀀스 사용)
	private int memberId; // : 입찰자 아이디
	private int bidprice; // : 입찰 가격
	private int bidstatus; // : 경매 입찰 상태
	private String account;
	//( 0: 입찰 상태 1 : 낙찰 확정 2: 낙찰 실패 3: 낙찰 진행 중 4 : 낙찰 포기 ) 
	/*
	 입찰 중 : 입찰을 한 상태를 의미
	낙찰 확정 : 낙찰에 성공
	낙찰 실패 : 낙찰에 실패함
	낙찰 포기 : 입찰에 포기해서 다음 순위자로 이동. 
	 */
	public int getAu_bidId() {
		return au_bidId;
	}
	public void setAu_bidId(int au_bidId) {
		this.au_bidId = au_bidId;
	}
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
	public int getBidprice() {
		return bidprice;
	}
	public void setBidprice(int bidprice) {
		this.bidprice = bidprice;
	}
	public int getBidstatus() {
		return bidstatus;
	}
	public void setBidstatus(int bidstatus) {
		this.bidstatus = bidstatus;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
}
