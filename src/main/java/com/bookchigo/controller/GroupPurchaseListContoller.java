package com.bookchigo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.Book;
import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;
import com.bookchigo.service.BookService;
import com.bookchigo.service.GroupPurchaseService;

@Controller
public class GroupPurchaseListContoller {
	
	@Autowired
	private GroupPurchaseService groupPurchaseService;
	
	// 전체목록 불러오기 
	@RequestMapping("/groupPurchase/list.do")
	
	public ModelAndView getPostList() {
		List<GroupPurchase> list = new ArrayList<>();
		
		list = groupPurchaseService.getGroupPurchaseList();
			
		Date now = new Date();
		System.out.println(now);
		
		for(int i=0; i<list.size(); i++) {
			if(now.before(list.get(i).getGp_date()) == false) { 
		        list.get(i).setIng(1); 
				groupPurchaseService.ingUpdate(list.get(i).getGp_postId()); 
			}
			if(list.get(i).getLimit() == list.get(i).getNow()) {
				list.get(i).setIng(1); 
		    	groupPurchaseService.ingUpdate(list.get(i).getGp_postId());
		    }
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("groupPurchase/gp_list");
		mav.addObject("PostList", list);
		return mav;
	}
	
	// 내가 모집하는 공구 불러오기
	@RequestMapping("/groupPurchase/ImReader/list.do")
	public ModelAndView getMyPostList(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		int session_memberId = Integer.parseInt((String) session.getAttribute("memberId"));
		
		List<GroupPurchase> list = new ArrayList<>();
		list = groupPurchaseService.getGroupPurchaseImReaderList(session_memberId); // 접속자(고유번호)가 쓴 게시글들을 불러온다.	
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("groupPurchase/gp_list_reader");
		mav.addObject("PostList", list);
			
		return mav;
	}
	
	// 내가 신청한 공구 불러오기
	@RequestMapping("/groupPurchase/ImApplier/list.do")
	public ModelAndView getMyApplyList(HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		int session_memberId = Integer.parseInt((String) session.getAttribute("memberId"));
		
		List<GroupPurchase> list = new ArrayList<>();
		List<GpApply> myApplyList = groupPurchaseService.getMyApplyList(session_memberId); 

		for(int i=0; i<myApplyList.size(); i++) {
			int gp_postId = myApplyList.get(i).getGp_postId();
			list.add(groupPurchaseService.getGpPostByPostId(gp_postId));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("groupPurchase/gp_list_applier");
		mav.addObject("PostList", list);
				
		return mav;
	}
	
	// 검색 :  게시글 제목 형태는 '<책제목>+게시글제목'
	@RequestMapping("/groupPurchase/search.do")
	@ModelAttribute("PostList")
	public ModelAndView getSearchList(@RequestParam("book_name") String book_name) {
		
		List<GroupPurchase> list = new ArrayList<>();
		list = groupPurchaseService.Search_GroupPurchase(book_name);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("groupPurchase/gp_list");
		mav.addObject("PostList", list);

		return mav;
	}

}
