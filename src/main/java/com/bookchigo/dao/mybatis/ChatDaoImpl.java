package com.bookchigo.dao.mybatis;

import com.bookchigo.dao.ChatDao;
import com.bookchigo.dao.mybatis.mapper.ChatMapper;
import com.bookchigo.domain.Chat;
import com.bookchigo.domain.ChatMessage;
import com.bookchigo.domain.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatDaoImpl implements ChatDao {
	@Autowired
	private ChatMapper chatMapper;

	@Override
	public int insertChatRoom(Chat chat) {
		return chatMapper.insertChatRoom(chat);
	}

	@Override
	public void insertChatMember(int chatId, int memberId) {
		chatMapper.insertChatMember(chatId, memberId);
	}

	@Override
	public int getSellerId(int sell_itemId) {
		return chatMapper.getSellerId(sell_itemId);
	}

	@Override
	public Chat getChatBySellId(int sell_itemId) {
		return chatMapper.getChatBySellId(sell_itemId);
	}

	@Override
	public Chat getChatByStudyId(int studyId) {
		return chatMapper.getChatByStudyId(studyId);
	}

	@Override
	public void insertChatMessage(ChatMessage chatMessage) {
		chatMapper.insertChatMessage(chatMessage);
	}

	@Override
	public List<ChatMessage> getChatMessageList(int chatId) {
		return chatMapper.getChatMessageList(chatId);
	}

	@Override
	public int getChatMember(int chatId, int memberId) {
		return chatMapper.getChatMember(chatId, memberId);
	}

	@Override
	public List<ChatRoom> getChatRoomList(int memberId) { return chatMapper.getChatRoomList(memberId); }
}
