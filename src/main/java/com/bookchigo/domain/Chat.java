package com.bookchigo.domain;

public class Chat {
	int chatId;

	int studyId;
	int sell_itemId;
	String registrationDate;

	@Override
	public String toString() {
		return "Chat{" +
				"chatId=" + chatId +
				", studyId=" + studyId +
				", sell_itemId=" + sell_itemId +
				", registrationDate='" + registrationDate + '\'' +
				'}';
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public int getStudyId() {
		return studyId;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public int getSell_itemId() {
		return sell_itemId;
	}

	public void setSell_itemId(int sell_itemId) {
		this.sell_itemId = sell_itemId;
	}
}
