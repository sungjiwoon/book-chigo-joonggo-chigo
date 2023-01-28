package com.bookchigo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.Member;
import com.bookchigo.domain.Notice;
import com.bookchigo.service.AuctionService;
import com.bookchigo.service.MemberService;
import com.bookchigo.util.ImageUtil;

@Controller
public class MainController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/main")
	public ModelAndView getList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String meString = (String) session.getAttribute("memberId");
		String username = (String) session.getAttribute("username");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main/main");
		if (meString == null) {
			mav.addObject("ses", 0);
		} else {
			System.out.println("MainController : login success!!!");
			System.out.println("MainController : username :: " + username);
			mav.addObject("ses", 1);
			mav.addObject("username", username);
		}
		return mav;
	}

}
