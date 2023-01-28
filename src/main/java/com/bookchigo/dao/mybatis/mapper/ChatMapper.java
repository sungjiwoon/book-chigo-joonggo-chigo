package com.bookchigo.dao.mybatis.mapper;

import com.bookchigo.domain.Chat;
import com.bookchigo.domain.ChatMessage;
import com.bookchigo.domain.ChatRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChatMapper {
	public int insertChatRoom(Chat chat);
	public void insertChatMember(@Param("chatId") int chatId, @Param("memberId") int memberId);
	public int getSellerId(int sell_itemId);

	public Chat getChatBySellId(int sell_itemId);
	public Chat getChatByStudyId(int studyId);
	public void insertChatMessage(ChatMessage chatMessage);
	public List<ChatMessage> getChatMessageList(int chatId);
	public int getChatMember(@Param("chatId") int chatId, @Param("memberId") int memberId);

	public List<ChatRoom> getChatRoomList(int memberId);
}