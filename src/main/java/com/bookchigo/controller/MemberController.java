package com.bookchigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.Member;
import com.bookchigo.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	// 로그인 페이지
    @RequestMapping(value = "/login")
    public String login() {
        return "member/login";
    }
    
	// 로그인 시도
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView loginDo(
    		@RequestParam ("username") String username,
    		@RequestParam ("password") String password) {

    	ModelAndView mv = new ModelAndView();

    	mv.setViewName("main"); 
    	if (memberService.isValidUser(username, password) == true) {
    		return mv;
    	} 
    	
    	mv.setViewName("member/login"); 
    	mv.addObject("isLoginFail", "true");

        return mv;
    }

	// 회원가입 페이지
    @RequestMapping(value = "/register")
    public String register() {
        return "member/register";
    }
    
    // 회원가입 입력
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public String registerDo(Member member) {
    	memberService.insertMember(member);
    	
    	return "redirect:login";
    }
}
