package com.bookchigo.domain;

public class GpApply {
	
	int memberId; // 이 멤버가 신청하거나 작성한 공구게시글을 나타내는 테이블이다
	int gp_postId; // 이 두가지가 키가 될듯 // '이글(포스트아이디)을 누가(멤버아이디)신청했느냐'
	String account;
	String id; 
	
	public GpApply(int gp_postId, int memberId,  String account, String id) {
		super();
		this.memberId = memberId;
		this.gp_postId = gp_postId;
		this.account = account;
		this.id = id;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getGp_postId() {
		return gp_postId;
	}
	public void setGp_postId(int gp_postId) {
		this.gp_postId = gp_postId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
