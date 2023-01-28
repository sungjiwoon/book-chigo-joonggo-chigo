package com.bookchigo.dao;

import com.bookchigo.domain.Chat;
import com.bookchigo.domain.ChatMessage;
import com.bookchigo.domain.ChatRoom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatDao {
	public int insertChatRoom(Chat chat);
	public void insertChatMember(int chatId, int memberId);
	public int getSellerId(int sell_itemId);

	public Chat getChatBySellId(int sell_itemId);
	public Chat getChatByStudyId(int studyId);
	public void insertChatMessage(ChatMessage chatMessage);
	public List<ChatMessage> getChatMessageList(int chatId);
	public int getChatMember(int chatId, int memberId);
	public List<ChatRoom> getChatRoomList(int memberId);
}
