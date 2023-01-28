package com.bookchigo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.Notice;
import com.bookchigo.service.NoticeService;


@Controller
@RequestMapping(value="/notice")
public class NoticeController {
	
private NoticeService noticeService;
	
	@Autowired
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@RequestMapping("/list.do")
	public ModelAndView getList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String meString = (String) session.getAttribute("memberId");
		
		List<Notice> list = null;
		list = this.noticeService.getNoticeList(Integer.parseInt(meString));
					
		System.out.println("NoticeController : 1 -1 " + meString);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/notice_list");
		System.out.println("NoticeController : 1 -2 ");
		if (list != null)
			mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/item.do")
	public ModelAndView getItem(HttpServletRequest request, @RequestParam("noticeId") int notice_id) {		
		Notice no = this.noticeService.getNotice(notice_id);
		System.out.println("NoticeController : 2 -1 ");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/notice_post");
		if (no != null)
			mav.addObject("no", no);
		System.out.println("NoticeController : 2 -2 ");
		this.noticeService.updateCount(notice_id, 1);
		System.out.println("NoticeController : 2 -3 ");
		return mav;
	}

}
