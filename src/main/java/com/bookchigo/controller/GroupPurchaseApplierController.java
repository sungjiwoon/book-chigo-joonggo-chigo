package com.bookchigo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.service.BookService;
import com.bookchigo.service.GroupPurchaseService;
import com.bookchigo.domain.Book;
import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;

@Controller
public class GroupPurchaseApplierController {

	@Autowired
	private GroupPurchaseService groupPurchaseService;
	
	@RequestMapping("/groupPurchase/apply.do")
	@ModelAttribute("GpDetail")
	public ModelAndView apply(HttpServletRequest request, 
			@RequestParam("gp_postId") int gp_postId) {
	
		HttpSession session = request.getSession(true);
		int session_memberId = Integer.parseInt((String) session.getAttribute("memberId"));
        String session_id = (String) session.getAttribute("username"); // 세션에서 얻음
        String session_account = (String) session.getAttribute("account"); // 세션에서 얻음
		
		groupPurchaseService.Apply_GroupPurchase(gp_postId);
		GpApply newApply = new GpApply(gp_postId, session_memberId, session_account, session_id);
		groupPurchaseService.insertGpApply(newApply); 
		
		int ing = groupPurchaseService.getGpPostByPostId(gp_postId).getIng();
		int limit = groupPurchaseService.getGpPostByPostId(gp_postId).getLimit();
	    int now = groupPurchaseService.getGpPostByPostId(gp_postId).getNow();
	    
	    if(limit == now) {
	    	groupPurchaseService.ingUpdate(gp_postId);
	    }

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/groupPurchase/ImApplier/list.do");
		
		return mav;
	}
	
	@RequestMapping("/groupPurchase/cancel.do")
	public ModelAndView cancel(HttpServletRequest request, 
			@RequestParam("gp_postId") int gp_postId) {
		
		HttpSession session = request.getSession(true);
		int session_memberId = Integer.parseInt((String) session.getAttribute("memberId")); // 세션에서 얻음
		String session_account = (String) session.getAttribute("account"); // 세션에서 얻음
        String session_id = (String) session.getAttribute("username"); // 세션에서 얻음
		
		groupPurchaseService.Cancel_GroupPurchase(gp_postId);
		GpApply delApply = new GpApply(gp_postId, session_memberId, session_account, session_id);

		groupPurchaseService.deleteGpApply(delApply);

		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("redirect:/groupPurchase/ImApplier/list.do");
		return mav;
	}

}
