package com.bookchigo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.AuctionBid;
import com.bookchigo.domain.AuctionItem;
import com.bookchigo.domain.SellItem;
import com.bookchigo.service.AuctionService;

@Controller
@RequestMapping(value="/auction")
public class AuctionController {

	   @Autowired
	   private AuctionService auctionService;
	   
	   public void setAuctionService(AuctionService auctionService) { 
	      this.auctionService = auctionService;
	   }
	   
	   //맨 처음 보여지는 컨트롤러 : 경매 게시물 리스트들을 보여줌. 
	    @RequestMapping(method = RequestMethod.GET)
		public ModelAndView getList(HttpServletRequest request) {
	    	HttpSession session = request.getSession();
			String meString = (String) session.getAttribute("memberId");
			int islogin = 1;
			if (meString == null) islogin = 0;
		   
			List<AuctionItem> list = null;
			list = this.auctionService.selectAuctionItemList();
			System.out.println("AuctionController : getList() -1 ");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("auction/auction_list");
			if (list != null)
				mav.addObject("list", list);
			mav.addObject("islogin", islogin);
			System.out.println("AuctionController : getList() -2 ");
			return mav;
		}
	   
	   //게시글 검색할 때 쓰이는 컨트롤러 , 작가와 도서 이름으로 검색이 가능함. 
	   @RequestMapping("/search.do")
		public ModelAndView searchAuctionItem(@RequestParam("key") String key, 
				@RequestParam("type_search") String type) {
			
		   List<AuctionItem> list = null;
		   if (type.equals("itemname")) {
			   System.out.println("AuctionController : searchAuctionItem  - itemName 1 ");
			   list = this.auctionService.searchAuctionByItemName(key);
		   } else if (type.equals("author")) {
			   System.out.println("AuctionController : searchAuctionItem  - author 1 ");
			   list = this.auctionService.searchAuctionByAuthor(key);	   
		   }
		   System.out.println("AuctionController : searchAuctionItem  -3 ");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("auction/auction_list_search");
			if (list != null)
				mav.addObject("list", list);
			mav.addObject("key", key);
			return mav;
		}
	   
	   @RequestMapping("/auctioneer.do")
		public ModelAndView getAuctioneerList(HttpServletRequest request) {
			HttpSession session = request.getSession();
			String meString = (String) session.getAttribute("memberId");
			int memberId = Integer.parseInt(meString);
			List<AuctionItem> list = null;
			list = this.auctionService.selectAuctionItemByMemberId(memberId);
			System.out.println("AuctionController : getAuctioneerList -1 ");
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("auction/auction_list_auctioneer");
			if (list != null)
				mav.addObject("list", list);
			System.out.println("AuctionController : getAuctioneerList -2 ");
			return mav;
		}
	   
	   @RequestMapping("/bidder.do")
		public ModelAndView getBidderList(HttpServletRequest request) {
			HttpSession session = request.getSession();
			String meString = (String) session.getAttribute("memberId");
			int memberId = Integer.parseInt(meString);
			
			List<AuctionBid> list = null;
			list = this.auctionService.selectAuctionBidByMemberId(memberId);
			System.out.println("AuctionController : getBidderList -1 ");
			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("auction/auction_list_bidder");
			if (list != null)
				mav.addObject("list", list);
			System.out.println("AuctionController : getBidderList -2 ");
			return mav;
		}
	   

}
