package com.bookchigo.domain;

public class ChatMessage {
	private int chatMessageId;
	private int chatId;

	private int memberId;
	private String id;
	private String message;
	private String registrationDate;

	@Override
	public String toString() {
		return "ChatMessage{" +
				"chatMessgeId=" + chatMessageId +
				", chatId=" + chatId +
				", memberId=" + memberId +
				", id='" + id + '\'' +
				", message='" + message + '\'' +
				", registrationDate='" + registrationDate + '\'' +
				'}';
	}

	public int getChatMessageId() {
		return chatMessageId;
	}

	public void setChatMessageId(int chatMessageId) {
		this.chatMessageId = chatMessageId;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
