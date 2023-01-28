package com.bookchigo.controller;

import java.util.List;

import javax.annotation.Resource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.AuctionBid;
import com.bookchigo.domain.AuctionItem;
import com.bookchigo.domain.SellItem;

import com.bookchigo.service.AuctionService;
import com.bookchigo.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;

@Controller
@RequestMapping(value="/auction")
public class AuctionPostController {
	
	private static final String FORM_VIEW = "auction/auction_upload";
	private static final String RESULT_VIEW = "auction/auction_read";

	   @Autowired
	   private AuctionService auctionService;
	  
	   @Autowired
	   private ImageUtil imageUtil; //image 파일 저장용
	   
//	   @Resource(name = "uploadPath")
//	   private String uploadPath;
	   
	   public void setAuctionService(AuctionService auctionService) { 
	      this.auctionService = auctionService;
	   }
	   
	   
	   //게시물 자세히 보고 싶을 때 사용. //경매 입찰 목록도 보여줌.  
	   @RequestMapping("/item.do")
		public ModelAndView getItem(HttpServletRequest request, 
				@RequestParam("item_id") int itemId) {
		   	HttpSession session = request.getSession();
			String meString = (String) session.getAttribute("memberId");
			System.out.println("AuctionPostController : getITem() 1: " + meString);
		
			ModelAndView mav = new ModelAndView();
			
			AuctionItem ai = this.auctionService.selectAuctionItem(itemId);
			List<AuctionBid> list = this.auctionService.selectAuctionBidList(itemId); //입찰 목록도 가져옴. 
			
			mav.setViewName(RESULT_VIEW);
			mav.addObject("ai", ai);
			mav.addObject("hostId", meString); //판매자랑 구매자 분리하기 위한 
			if (list != null ) {
				mav.addObject("bidList", list);
				mav.addObject("haveBid", 1);
			} else {
				mav.addObject("haveBid", 0);
			}
			return mav;
		}
	   
	   // 경매 게시글 등록 페이지
		@RequestMapping(value = "/upload")
		public ModelAndView form() {
			System.out.println("AuctionPostController : form() 1: ");
			ModelAndView mav = new ModelAndView();
			mav.setViewName(FORM_VIEW);
			return mav;
		}

		// 경매 게시글 등록 요청
		@RequestMapping(value = "/upload.do", method = RequestMethod.POST)
		public ModelAndView uploadPost(HttpServletRequest request,
								 AuctionItem ai,
								 MultipartFile img_file) {

			HttpSession session = request.getSession();
			String meString = (String) session.getAttribute("memberId");
			System.out.println("AuctionPostController : uploadPost() 1: " + meString);
			System.out.println(ai.getCondition() + ai.getItemname() + ai.getPublisher() + ai.getAuthor() + ai.getStartprice() + ai.getDeadline());
//			int memberId = (int) session.getAttribute("memberId");
			
			if (meString != null) {
				System.out.println("AuctionPostController : uploadPost() 1-2: " + meString);
				int memberId = Integer.parseInt(meString);
				String account = (String) session.getAttribute("account");
				ai.setAccount(account);
				ai.setMemberId(memberId);
				ai.setAu_bidId(0);
				ai.setFinalprice(0);
				ai.setAu_memberId(0);
				ai.setDealstatus(0);
			}

			String imagePath = imageUtil.uploadImage(request, img_file);
			ai.setImageurl(imagePath);
			System.out.println("AuctionPostController : uploadPost() 2: ");
			this.auctionService.insertAuctionItem(ai);
			System.out.println("AuctionPostController : uploadPost() 3: ");
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName(RESULT_VIEW);
			if (ai != null)
				mav.addObject("ai", ai);
			mav.addObject("memberId", meString);
			System.out.println("AuctionPostController : uploadPost() 4: ");
			return mav;
		}
		
		@RequestMapping("/delete.do")
		public ModelAndView delete(@RequestParam("itemId") int au_itemId) {
			
			this.auctionService.deleteAuctionBid(au_itemId);
			this.auctionService.deleteAuctionItem(au_itemId);
			
//			List<AuctionItem> list = null;
//			list = this.auctionService.
//			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("auction/auction_delete_success");
			return mav;
		}
	   
}
