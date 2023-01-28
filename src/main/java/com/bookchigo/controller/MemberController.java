package com.bookchigo.controller;

import com.bookchigo.domain.Member;
import com.bookchigo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	// 로그인 페이지
    @RequestMapping(value = "/login")
    public String login() {
		System.out.println("member/login");
		return "member/login";
    }
    
	// 로그인 시도
    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView loginDo(
			HttpServletRequest request,
    		@RequestParam ("username") String username,
    		@RequestParam ("password") String password) {

    	ModelAndView mv = new ModelAndView();

    	Map<String, String> account = memberService.isValidUser(username, password);

		System.out.println(account);

    	if (account != null) {
			// 로그인 세션 처리
			HttpSession session = request.getSession();
			session.setAttribute("username", account.get("username"));
			session.setAttribute("account", account.get("account"));
			session.setAttribute("memberId", account.get("memberId"));

			mv.setViewName("redirect:/main");

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

	// 로그아웃
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logoutDo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("account");
		session.removeAttribute("memberId");

		return "redirect:/main";
	}

	// 로그아웃
	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String deleteDo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int memberId = Integer.parseInt((String)session.getAttribute("memberId"));

		memberService.deleteMember(memberId);

		session.removeAttribute("username");
		session.removeAttribute("account");
		session.removeAttribute("memberId");

		return "redirect:/main";
	}

	// MY 정보 보기
	@RequestMapping(value = "/my", method = RequestMethod.GET)
	public ModelAndView my(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int memberId = Integer.parseInt((String)session.getAttribute("memberId"));

		Member member = memberService.getMemberInfo(memberId);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/my");
		mv.addObject("member", member);

		return mv;
	}
}
