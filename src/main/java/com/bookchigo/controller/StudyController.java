package com.bookchigo.controller;

import com.bookchigo.domain.Study;
import com.bookchigo.service.StudyService;
import com.bookchigo.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/study")
public class StudyController {
	@Autowired
	private StudyService studyService;

	@Autowired
	private ImageUtil imageUtil;

	@Resource(name = "uploadPath")
	private String uploadPath;

	// 스터디 목록 페이지
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list() {
		List<Study> list = studyService.getStudyList();

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("study/list");

		System.out.println(list.size());
		return mv;
	}

	// 스터디 등록 페이지
	@RequestMapping(value = "/register")
	public String register() {
		return "study/enroll";
	}

	// 스터디 등록 요청
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String registerDo(HttpServletRequest request,
							 Study study,
							 MultipartFile file) {

		HttpSession session = request.getSession();
		String meString = (String) session.getAttribute("memberId");

		if (meString != null) {
			int memberId = Integer.parseInt((String) session.getAttribute("memberId"));
			String account = (String) session.getAttribute("account");
			study.setAccount(account);
			study.setHostId(memberId);
		}

		String imagePath = imageUtil.uploadImage(request, file);

		study.setBookImageUrl(imagePath);
		studyService.insertStudy(study);
		return "redirect:/study";
	}
}
