package com.bookchigo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.AuctionBid;
import com.bookchigo.domain.AuctionItem;
import com.bookchigo.domain.Member;
import com.bookchigo.domain.Notice;
import com.bookchigo.service.AuctionService;

@Controller
@RequestMapping(value="/auction")
public class AuctionBidController {
	
	private static final String FORM_VIEW = "auction/auction_bidApply";
	private static final String RESULT_VIEW = "auction/auction_bidComplete";
	private static final String CLOSE_VIEW = "auction/auction_itemClose";
	
	 @Autowired
	   private AuctionService auctionService;
	   
	   public void setAuctionService(AuctionService auctionService) { 
	      this.auctionService = auctionService;
	   }
	   
	   public static java.sql.Date getCurrentDatetime() {
	       java.util.Date today = new java.util.Date();
	       return new java.sql.Date(today.getTime());
	   }
	   
	   // 경매 입찰 등록 페이지
		@RequestMapping(value = "/apply")
		public ModelAndView form(HttpServletRequest request, @RequestParam("itemId") int item_id, @RequestParam("startprice") int price) {
			ModelAndView mav = new ModelAndView();
			mav.setViewName(FORM_VIEW);
			mav.addObject("item_id", item_id);
			mav.addObject("startprice", price);
			System.out.println("AuctionBidController form : " + item_id);
			
			return mav;			
		}

		// 경매 게시글 등록 요청
	   @RequestMapping(value = "/apply.do", method = RequestMethod.POST)
	   public ModelAndView applyBid(HttpServletRequest request, AuctionBid ab) {
		   HttpSession session = request.getSession();
		   String meString = (String) session.getAttribute("memberId");
		   int memberId = 0;
		   System.out.println("AuctionBidController : "+meString);
		   System.out.println("AuctionBidController applyBid : " + ab.getAu_itemId());
		   if (meString != null) {
			   memberId = Integer.parseInt(meString);
			   String account = (String) session.getAttribute("account");
			   ab.setAccount(account);
			   ab.setBidstatus(0);
			   ab.setMemberId(memberId);
			}
		   
//		   	int memberId = 2;
//			String account = "222-11111-111";
//			ab.setAccount(account);
//			ab.setAu_member_id(memberId);
//			ab.setBid_status(0);
			this.auctionService.insertAuctionBid(ab);
				
			AuctionItem ai = this.auctionService.selectAuctionItem(ab.getAu_itemId());
			Member member = this.auctionService.selectMemberByAuction(memberId);
				
			ModelAndView mav = new ModelAndView();
			mav.setViewName(RESULT_VIEW);
			if (ab != null) {
				mav.addObject("ab", ab);
				mav.addObject("host_name", member.getName());
				mav.addObject("item_name", ai.getItemname());
			}
			return mav;
	   }
	   
	   @RequestMapping(value = "/close")
	   public ModelAndView closeAuction(HttpServletRequest request, 
			   @RequestParam("itemId") int itemId ) {
		   HttpSession session = request.getSession();
		   String meString = (String) session.getAttribute("memberId");
		   
		   AuctionItem ai = this.auctionService.selectAuctionItem(itemId);
//		   ai.setDealstatus(1); //(0 : 입찰 상태  1 : 낙찰 확정  2 : 낙찰 실패 3: 낙찰 진행 중  4: 낙찰 포기  )
		   System.out.println("AuctionBidController : closeAuction() 1: " + meString + " " + ai.getAu_itemId() +" " + ai.getMemberId() );
//		   this.auctionService.updateAuctionItemDealStatus(ai);
//		   System.out.println("AuctionBidController : closeAuction() 2 " + itemId);
		   
		   AuctionBid maxBid = this.auctionService.selectAuctionBidOrderByPrice(itemId);
		   System.out.println("AuctionBidController : closeAuction() 3: " + maxBid);
		   
		   if (maxBid != null) {
			   System.out.println("max Bid " + maxBid.getAu_bidId() + " "+maxBid.getBidprice());
			   maxBid.setBidstatus(1);//( 0: 입찰 상태  1 : 낙찰 확정 2: 낙찰 실패 3: 낙찰 진행 중 4 : 낙찰 포기 5: 경매 마감.  ) 
			   
			   System.out.println("AuctionBidController : closeAuction() 4: ");
			   this.auctionService.updateAuctionBidDealStatus(maxBid);
			  
			   System.out.println("AuctionBidController : closeAuction() 5: ");
			   int bidstatus = 5;
			   this.auctionService.updateAuctionBidDealStatusByAll(bidstatus, ai.getAu_itemId());
			   
			   System.out.println("AuctionBidController : closeAuction() 6: ");
			   ai.setAu_memberId(maxBid.getMemberId());
			   ai.setDealstatus(1);
			   ai.setFinalprice(maxBid.getBidprice());
			   ai.setAu_bidId(maxBid.getAu_bidId());
			   this.auctionService.updateAuctionItemDealStatus(ai);
			  
			   System.out.println("AuctionBidController : closeAuction() 6-2: ");
			   // 낙찰자한테 메세지 보내기 
			   Member member = this.auctionService.selectMemberByAuction(maxBid.getMemberId()); //낙찰자 정보 뽑아오기. 
			   
			   System.out.println("AuctionBidController : closeAuction() 7: ");
			   String title = "경매 <" + ai.getItemname() + "> 낙찰 되셨습니다. ";
			   String content = "경매 <" + ai.getItemname() + "> (고유 id: " + ai.getAu_itemId() + ")에 낙찰 되셨습니다.<br>"
			   		+ "낙찰자  < " + member.getName() + " > 님은  해당 계좌번호 < "+ ai.getAccount() + " > 로 입금 금액  < " + maxBid.getBidprice() + " 원>을 넣어주세요.<br>"
			   		+ "판매자에게도 해당 고객님의 정보가 전송되었습니다. 축하드립니다. <br>";
			   System.out.println("AuctionBidController : closeAuction() " + title);
			   Notice no = new Notice();
			   java.sql.Date date_now = getCurrentDatetime();
			   
			   no.setAccount(member.getAccount());
			   no.setTitle(title);
			   no.setContent(content);
			   no.setMemberId(maxBid.getMemberId());
			   no.setCount(0);
			   no.setNotice_date(date_now);
			   this.auctionService.insertNoticeMessageByAuction(no);
			   
			   System.out.println("AuctionBidController : closeAuction() 8: ");
			   
			   // 판매자에게 메세지 보내기 
			   title = "경매 <" + ai.getItemname() + "> 낙찰자 정보입니다. ";
			   content = "경매 <" + ai.getItemname() + "> (고유 id: " + ai.getAu_itemId() + ") 마감하셨습니다. <br>"
					+ "최종 낙찰 가격은 <" + maxBid.getBidprice() + "원> 입니다. <br>"
			   		+ "낙찰자는 <" + member.getName() + "> 님이며  핸드폰 번호는 < "+ member.getPhone() + " > , 주소는  < " + member.getAddress() + ">로 입니다.<br>"
			   		+ "낙찰자에게도 해당 고객님의 정보가 전송되었습니다. 감사합니다. <br>";
			   System.out.println("AuctionBidController : closeAuction() " + title);
			   Notice no2 = new Notice();
			   no2.setAccount(ai.getAccount());
			   no2.setTitle(title);
			   no2.setContent(content);
			   no2.setMemberId(ai.getMemberId());
			   no2.setCount(0);
			   no2.setNotice_date(date_now);
			   this.auctionService.insertNoticeMessageByAuction(no2);
			   
			   System.out.println("AuctionBidController : closeAuction() 9 ");			   
			   ModelAndView mav = new ModelAndView();
			   mav.setViewName(CLOSE_VIEW);
			   mav.addObject("ai", ai);
			   mav.addObject("ab", maxBid);
			   mav.addObject("bid_member", member);
			   mav.addObject("bid_ok", 1);
			   
			   return mav;
		   } else {
			   ai.setAu_memberId(-1);
			   ai.setDealstatus(1);
			   ai.setFinalprice(-1);
			   this.auctionService.updateAuctionItemDealStatus(ai);
			   System.out.println("AuctionBidController : closeAuction() 6-3: ");
			   ModelAndView mav = new ModelAndView();
			   mav.addObject("ai", ai);
			   mav.setViewName(CLOSE_VIEW);
			   mav.addObject("bid_ok", 0);
			   return mav;
		   }
		   
		   
	   }
	   
}
