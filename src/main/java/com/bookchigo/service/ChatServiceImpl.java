package com.bookchigo.service;

import com.bookchigo.dao.ChatDao;
import com.bookchigo.domain.Chat;
import com.bookchigo.domain.ChatMessage;
import com.bookchigo.domain.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	private ChatDao chatDao;

	@Override
	public List<Chat> getChatList() {
		return null;
	}

	@Override
	public List<ChatMessage> getChatMessageList(int chatId) {
		return chatDao.getChatMessageList(chatId);
	}

	@Override
	public Chat getChatBySellId(int sell_itemId) {
		Chat chat = chatDao.getChatBySellId(sell_itemId);
		return chat;
	}

	@Override
	public Chat getChatByStudyId(int studyId) {
		Chat chat = chatDao.getChatByStudyId(studyId);
		return chat;
	}

	@Override
	public int insertChat(Chat chat, int memberId) {
		chatDao.insertChatRoom(chat);
		int chatId = chat.getChatId();

		System.out.println("chatId : " + chatId);
		chatDao.insertChatMember(chatId, memberId);

		if (chat.getSell_itemId() != 0) { // 1:1 판매 채팅
			int sellerId = chatDao.getSellerId(chat.getSell_itemId());
			chatDao.insertChatMember(chatId, sellerId);
		}

		return chatId;
	}

	@Override
	public void insertChatMessage(ChatMessage chatMessage) {
		chatDao.insertChatMessage(chatMessage);
	}

	@Override
	public void insertChatMember(int chatId, int memberId) {
		int count = chatDao.getChatMember(chatId, memberId);

		System.out.println("---");
		System.out.println(chatId);
		System.out.println(memberId);
		System.out.println(count);
		System.out.println("---");

		if (count == 0) {
			chatDao.insertChatMember(chatId, memberId);
		}
	}

	@Override
	public List<ChatRoom> getChatRoomList(int memberId) { return chatDao.getChatRoomList(memberId); }
}
