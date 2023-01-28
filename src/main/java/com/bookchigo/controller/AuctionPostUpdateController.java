package com.bookchigo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.AuctionBid;
import com.bookchigo.domain.AuctionItem;
import com.bookchigo.service.AuctionService;
import com.bookchigo.util.ImageUtil;

@Controller
@RequestMapping(value="/auction")
public class AuctionPostUpdateController {
	private static final String FORM_VIEW = "auction/auction_update";
	private static final String RESULT_VIEW = "auction/auction_read";
	@Autowired
	private AuctionService auctionService;
	  
	@Autowired
	private ImageUtil imageUtil; //image 파일 저장용
	   
	public void setAuctionService(AuctionService auctionService) { 
		this.auctionService = auctionService;
	}

	//게시물 자세히 보고 싶을 때 사용. //경매 입찰 목록도 보여줌.  
	@RequestMapping("/update")
	public ModelAndView updateForm(HttpServletRequest request, @RequestParam("itemId") int au_itemId) {
		System.out.println("updateForm 1 : " + au_itemId);
		ModelAndView mav = new ModelAndView();			
		AuctionItem ai = this.auctionService.selectAuctionItem(au_itemId); 
		System.out.println("updateForm 2");	
		mav.setViewName(FORM_VIEW);
		mav.addObject("ai", ai);
		return mav;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView updatePost(HttpServletRequest request,  @RequestParam("itemId") int au_itemId,
			 AuctionItem ai, MultipartFile img_file) {
		
		String imagePath = imageUtil.uploadImage(request, img_file);
		ai.setImageurl(imagePath);
	    ai.setAu_itemId(au_itemId);  
	    this.auctionService.updateAuctionItem(ai);
	    System.out.println("update 1");  
	  	HttpSession session = request.getSession();
		String meString = (String) session.getAttribute("memberId");
		
		System.out.println("update 2 session : " + meString);  
	
		ModelAndView mav = new ModelAndView();
		List<AuctionBid> list = this.auctionService.selectAuctionBidList(au_itemId); //입찰 목록도 가져옴. 
		System.out.println("update 3");  
		mav.setViewName("redirect:/auction/item.do?item_id=" + au_itemId);
		return mav;
	}
}
