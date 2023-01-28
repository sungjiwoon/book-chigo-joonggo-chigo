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

import com.bookchigo.dao.GroupPurchaseDao;
import com.bookchigo.domain.Book;
import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;
import com.bookchigo.service.BookService;
import com.bookchigo.service.GroupPurchaseService;

@Controller
public class GroupPurchaseController {
	
	@Autowired
	private GroupPurchaseService groupPurchaseService;
	
	@Autowired
	private BookService bookService;
	

	//  자세히 목록에서 눌렀을 때 
	@RequestMapping("/groupPurchase/detail.do")
	@ModelAttribute("GpDetail")
	public ModelAndView detailPost(HttpServletRequest request, 
			@RequestParam("gp_postId") int gp_postId) 
	{
		HttpSession session = request.getSession(true);
		int session_memberId = Integer.parseInt((String) session.getAttribute("memberId"));
		
	    GroupPurchase gpDetail = new GroupPurchase();
		gpDetail = groupPurchaseService.Detail_GroupPurchase(gp_postId);
		
		int ing = groupPurchaseService.getGpPostByPostId(gp_postId).getIng();
		Book Thisbook = bookService.getBookById(gpDetail.getBook_id());
		
        List<GpApply> list = null;
        list = groupPurchaseService.getWhoApplierList(gp_postId);
       
		int readerMemberId = groupPurchaseService.getGpPostByPostId(gp_postId).getReaderMemberId();
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("gpDetail", gpDetail);
		mav.addObject("Thisbook", Thisbook);
		
		if (ing == 1) {
			// ing==1이면 이미 마감된 공구이다.
			if(session_memberId == readerMemberId) {
				mav.addObject("Appliers", list);
				mav.setViewName("groupPurchase/gp_detail_finish_reader");
				return mav;
			}
			mav.setViewName("groupPurchase/gp_detail_finish"); // 이미 마감된 공구
			return mav;
		}
			
		if (session_memberId == readerMemberId) {
			mav.setViewName("groupPurchase/gp_detail_reader"); // 내가 쓴 공구게시글
			mav.addObject("Appliers", list);
			mav.addObject("gpDetail", gpDetail);
			mav.addObject("Thisbook", Thisbook);
			return mav;
			
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getMemberId() == session_memberId) { 
				mav.setViewName("groupPurchase/gp_detail_applier"); // 내가 이미 신청한 공구일 때
				mav.addObject("gpDetail", gpDetail);
				mav.addObject("Thisbook", Thisbook);
				return mav;
			}
		}	
		
		mav.setViewName("groupPurchase/gp_detail"); 
		mav.addObject("gpDetail", gpDetail);
		mav.addObject("Thisbook", Thisbook);
		return mav;
		
	}
	
}
