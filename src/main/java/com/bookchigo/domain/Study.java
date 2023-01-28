package com.bookchigo.domain;

public class Study {
	int studyId;
	String account;

	int hostId;
	String studyName;
	String bookName;
	String bookAuthor;
	String bookImageUrl;
	int currentMemberCnt;
	int maxMemberCnt;
	String introduction;
	String discussionDate;

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getHostId() {
		return hostId;
	}

	public void setHostId(int hostId) {
		this.hostId = hostId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookImageUrl() {
		return bookImageUrl;
	}

	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}

	public int getCurrentMemberCnt() {
		return currentMemberCnt;
	}

	public void setCurrentMemberCnt(int currentMemberCnt) {
		this.currentMemberCnt = currentMemberCnt;
	}

	public int getMaxMemberCnt() {
		return maxMemberCnt;
	}

	public void setMaxMemberCnt(int maxMemberCnt) {
		this.maxMemberCnt = maxMemberCnt;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDiscussionDate() {
		return discussionDate;
	}

	public void setDiscussionDate(String discussionDate) {
		this.discussionDate = discussionDate;
	}

	@Override
	public String toString() {
		return "Study{" +
				"studyId=" + studyId +
				", account='" + account + '\'' +
				", hostId=" + hostId +
				", studyName='" + studyName + '\'' +
				", bookName='" + bookName + '\'' +
				", bookAuthor='" + bookAuthor + '\'' +
				", bookImageUrl='" + bookImageUrl + '\'' +
				", currentMemberCnt=" + currentMemberCnt +
				", maxMemberCnt=" + maxMemberCnt +
				", introduction='" + introduction + '\'' +
				", discussionDate='" + discussionDate + '\'' +
				'}';
	}

}
