package com.bookchigo.service;

import com.bookchigo.domain.Chat;
import com.bookchigo.domain.ChatMessage;
import com.bookchigo.domain.ChatRoom;

import java.util.List;

public interface ChatService {
	public List<Chat> getChatList();
	public List<ChatMessage> getChatMessageList(int chatId);
	public Chat getChatBySellId(int sell_itemId);
	public Chat getChatByStudyId(int studyId);

	public int insertChat(Chat chat, int memberId);
	public void insertChatMessage(ChatMessage chatMessage);
	public void insertChatMember(int chatId, int memberId);
	public List<ChatRoom> getChatRoomList(int memberId);
}
