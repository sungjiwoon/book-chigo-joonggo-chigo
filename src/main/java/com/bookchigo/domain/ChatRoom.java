package com.bookchigo.domain;

public class ChatRoom {
	private int chatId;
	private String studyName;
	private String sell_itemName;
	private int sell_itemId;
	private int studyId;
	private String message;
	private String registrationDate;
	private String bookImageUrl;
	private String sell_image;

	@Override
	public String toString() {
		return "ChatRoom{" +
				"chatId=" + chatId +
				", studyName='" + studyName + '\'' +
				", sell_itemName='" + sell_itemName + '\'' +
				", sell_itemId=" + sell_itemId +
				", studyId=" + studyId +
				", message='" + message + '\'' +
				", registrationDate='" + registrationDate + '\'' +
				", bookImageUrl='" + bookImageUrl + '\'' +
				", sell_image='" + sell_image + '\'' +
				'}';
	}

	public String getBookImageUrl() {
		return bookImageUrl;
	}

	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}

	public String getSell_image() {
		return sell_image;
	}

	public void setSell_image(String sell_image) {
		this.sell_image = sell_image;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getStudyName() {
		return studyName;
	}

	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}

	public String getSell_itemName() {
		return sell_itemName;
	}

	public void setSell_itemName(String sell_itemName) {
		this.sell_itemName = sell_itemName;
	}

	public int getSell_itemId() {
		return sell_itemId;
	}

	public void setSell_itemId(int sell_itemId) {
		this.sell_itemId = sell_itemId;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
}
