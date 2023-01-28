package com.bookchigo.controller;

import com.bookchigo.domain.Chat;
import com.bookchigo.domain.ChatMessage;
import com.bookchigo.domain.ChatRoom;
import com.bookchigo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(value = "/chat")
public class ChatController {
	@Autowired
	private ChatService chatService;

	// 채팅 목록 페이지
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) {

		HttpSession session = request.getSession();
		int memberId = Integer.parseInt((String)session.getAttribute("memberId"));

		List<ChatRoom> list = chatService.getChatRoomList(memberId);

		for (int i = 0; i < list.size(); i++) {
			ChatRoom chatRoom = list.get(i);
			System.out.println(chatRoom);

			if (chatRoom.getStudyId() == 0 && chatRoom.getSell_itemId() == 0) {
				list.remove(i);
				i--;
			}
		}
		System.out.println(list);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("chat/list");

		return mv;
	}

	// 채팅방 페이지
	@RequestMapping(value = "/room")
	public ModelAndView room(
			HttpServletRequest request,
			@RequestParam(required = false, value="seid") String sellId,
			@RequestParam(required = false, value="stid") String studyId) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat/chat");

		HttpSession session = request.getSession();
		int memberId = Integer.parseInt((String)session.getAttribute("memberId"));
		String username = (String) session.getAttribute("username");

		int chatId = -1;
		Chat chat = null;

		mv.addObject("username", username);
		mv.addObject("memberId", memberId);

		if (sellId != null) {
			int sellIdInt = Integer.parseInt(sellId);

			// 판매 채팅 (1:1)
			chat = chatService.getChatBySellId(sellIdInt);

			System.out.println("DEBUG00");
			System.out.println(chat);

			// 기존 채팅창 없는 경우, 채팅방 생성
			if (chat == null) {
				chat = new Chat();
				chat.setSell_itemId(sellIdInt);

				chat.setChatId(chatService.insertChat(chat, memberId));

				//return mv;
			}

			chatService.insertChatMember(chat.getChatId(), memberId);
			mv.addObject("chatRoomId", "se_" + chat.getChatId());
			mv.addObject("chatId", chat.getChatId());

		} else if (studyId != null) {
			int studyIdInt = Integer.parseInt(studyId);

			// 그룹 채팅 (1:N)
			chat = chatService.getChatByStudyId(studyIdInt);

			System.out.println("DEBUG00");
			System.out.println(chat);
			// 기존 채팅창 없는 경우, 채팅방 생성
			if (chat == null) {
				chat = new Chat();
				chat.setStudyId(studyIdInt);

				System.out.println("DEBUG001");

				chat.setChatId(chatService.insertChat(chat, memberId));
			}

			chatService.insertChatMember(chat.getChatId(), memberId);
			mv.addObject("chatRoomId", "st_" + chat.getChatId());
			mv.addObject("chatId", chat.getChatId());
		}

		List<ChatMessage> messages = chatService.getChatMessageList(chat.getChatId());

		mv.addObject("messages", messages);

		return mv;
	}

	// 채팅 메시지 입력
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String insert(@RequestBody ChatMessage message) {
		message.setRegistrationDate(LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

		System.out.println(message);
		chatService.insertChatMessage(message);
		return "success";
	}
}
