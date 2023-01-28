package com.bookchigo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.Book;
import com.bookchigo.domain.GpApply;
import com.bookchigo.domain.GroupPurchase;
import com.bookchigo.service.BookService;
import com.bookchigo.service.GroupPurchaseService;
import com.bookchigo.util.ImageUtil;

@Controller	
public class GroupPurchaseReaderController {
	
	@Autowired
	private GroupPurchaseService groupPurchaseService;
	
	@Autowired
	private BookService bookService;
	
	
	@Autowired
    private ImageUtil imageUtil; //image 파일 저장용
	
	// 게시글 등록하는 페이지 불러오기
	@RequestMapping("/groupPurchase/uploadForm.do")
	@ModelAttribute("gpForm")
	public ModelAndView uploadForm(HttpServletRequest request) {
		
		 HttpSession session = (HttpSession) request.getSession(true);
		 int session_memberId = Integer.parseInt((String) session.getAttribute("memberId"));
		 String session_id = (String) session.getAttribute("username");
		 String session_account = (String) session.getAttribute("account");
		 
		 GroupPurchase gpForm = new GroupPurchase();
		 gpForm.setAccount(session_account);
		 gpForm.setReaderMemberId(session_memberId);
		 gpForm.setReaderId(session_id);
	    
		ModelAndView mav = new ModelAndView();
		mav.setViewName("groupPurchase/gp_upload");
		mav.addObject("gpForm", gpForm);
		
		return mav;
	}

	
	@RequestMapping("/groupPurchase/upload.do")
	public ModelAndView uploadPost(HttpServletRequest request, 
			@RequestParam("book_id") int book_id,
			@RequestParam("book_name") String book_name,
			@RequestParam("book_writer") String book_writer,
			@RequestParam("book_publisher") String book_publisher,
			@RequestParam("book_price") int book_price,
			@RequestParam("book_summary") String book_summary,
			@RequestParam("readerId") String readerId,
			@RequestParam("readerMemberId") int readerMemberId, 
			@RequestParam("post_title") String post_title, 
			@RequestParam("gp_date") @DateTimeFormat (pattern ="yyyy-MM-dd") Date gp_date,  
			@RequestParam("limit") int limit, 
			@RequestParam("dis_price") int dis_price, 
			@RequestParam("post_contents") String post_contents,
			@RequestParam ("account") String account,
			MultipartFile img_file) {
		
		String book_photo = imageUtil.uploadImage(request, img_file);
		System.out.println("uploadPost book_photo : " + book_photo);
		Book book= new Book(book_id, book_name, book_writer, book_publisher, book_price, book_summary, book_photo);
		bookService.insertBook(book);
	
		GroupPurchase gpUpload = new GroupPurchase(book_id, post_title, post_contents, readerMemberId, gp_date, 0, limit, 0, account, 
				dis_price, readerId, book_photo);
		gpUpload = groupPurchaseService.Upload_GroupPurchase(gpUpload);
		      
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("redirect:/groupPurchase/ImReader/list.do");

		
		return mav;
	}
	
	@RequestMapping("/groupPurchase/delete.do") 
	public ModelAndView deletePost(HttpServletRequest request, 
			@RequestParam("gp_postId") int gp_postId) {
	
		ModelAndView mav = new ModelAndView();
		
		GroupPurchase gpDel = groupPurchaseService.getGpPostByPostId(gp_postId);
		
		Book Thisbook = bookService.getBookById(gpDel.getBook_id());
		
		int now = groupPurchaseService.getGpPostByPostId(gp_postId).getNow();

		List<GpApply> Alist = null;
        Alist = groupPurchaseService.getWhoApplierList(gp_postId);
        mav.addObject("Appliers", Alist);
        
		if (now != 0) {
			mav.setViewName("groupPurchase/gp_detail_reader");
			
			GroupPurchase gpDetail = new GroupPurchase();
			gpDetail = groupPurchaseService.Detail_GroupPurchase(gp_postId);
			
			mav.addObject("message", "이미 신청자가 있으므로 삭제가 불가합니다.");
			mav.addObject("gpDetail", gpDetail);
			mav.addObject("Thisbook", Thisbook);
			
			return mav;		
		}	
		
		int readerMemberId = groupPurchaseService.getGpPostByPostId(gp_postId).getReaderMemberId();
		int book_id = groupPurchaseService.getGpPostByPostId(gp_postId).getBook_id();
		
		groupPurchaseService.Delete_GroupPurchase(gp_postId);
		bookService.deleteBook(book_id);
		
		// List<GroupPurchase> list = 	groupPurchaseService.getGroupPurchaseImReaderList(readerMemberId);
		// mav.setViewName("groupPurchase/Posts_reader");
		// mav.addObject("PostList", list);	
		mav.setViewName("redirect:/groupPurchase/ImReader/list.do");
		return mav;
		
	}
	
	@RequestMapping("/groupPurchase/updateForm.do") 
	public ModelAndView updateForm(HttpServletRequest request, 
			@RequestParam("gp_postId") int gp_postId) {
		
		ModelAndView mav = new ModelAndView();
		GroupPurchase gpUpdate = groupPurchaseService.getGpPostByPostId(gp_postId);
		
		Book Thisbook = bookService.getBookById(gpUpdate.getBook_id());
		
		List<GpApply> Alist = null;
        Alist = groupPurchaseService.getWhoApplierList(gp_postId);
        mav.addObject("Appliers", Alist);
		
		gpUpdate = groupPurchaseService.Detail_GroupPurchase(gp_postId);
		mav.addObject("gpUpdate", gpUpdate);
		mav.addObject("Thisbook", Thisbook);
		
		int now = groupPurchaseService.getGpPostByPostId(gp_postId).getNow();
		
		if (now != 0) {			
			mav.setViewName("groupPurchase/gp_detail_reader");
			
			GroupPurchase gpDetail = new GroupPurchase();
			gpDetail = groupPurchaseService.Detail_GroupPurchase(gp_postId);
			
			mav.addObject("message", "이미 신청자가 있으므로 수정이 불가합니다.");
			mav.addObject("gpDetail", gpDetail);
			mav.addObject("Thisbook", Thisbook);
			return mav;
			
		}	
		mav.setViewName("groupPurchase/gp_update");	
		return mav;
	}
	
	@RequestMapping("/groupPurchase/update.do")
	public ModelAndView update(HttpServletRequest request,
			@RequestParam("book_id") int book_id,
			@RequestParam("gp_postId") int gp_postId,
			@RequestParam("post_title") String post_title, 
			@RequestParam("gp_date")@DateTimeFormat (pattern ="yyyy-MM-dd") Date gp_date,  
			@RequestParam("limit") int limit, 
			@RequestParam("dis_price") int dis_price, 
			@RequestParam("post_contents") String post_contents,
			@RequestParam ("account") String account) {
		

		GroupPurchase gpDetail = new GroupPurchase();
		gpDetail = groupPurchaseService.Detail_GroupPurchase(gp_postId);
		
		ModelAndView mav = new ModelAndView();
		Book Thisbook = bookService.getBookById(book_id);
		
		GroupPurchase gpUpdate = new GroupPurchase(post_title, post_contents, gp_date, limit, dis_price, gp_postId);
		gpDetail = groupPurchaseService.Update_GroupPurchase(gpUpdate);
		
		mav.setViewName("groupPurchase/gp_detail_reader");
		
		gpDetail = groupPurchaseService.Detail_GroupPurchase(gp_postId);
		
		mav.addObject("Thisbook", Thisbook);
		mav.addObject("gpDetail", gpDetail);
	
		return mav;
		
	}

}