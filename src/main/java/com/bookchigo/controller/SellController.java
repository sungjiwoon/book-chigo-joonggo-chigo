package com.bookchigo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookchigo.domain.SellItem;
import com.bookchigo.service.SellServiceFacade;

@Controller
//@RequestMapping("/sell")
public class SellController {
	
	private SellServiceFacade sellService;
	
	@Autowired
	public void setPetStore(SellServiceFacade sellService) {
		this.sellService = sellService;
	}
	
	@RequestMapping("/sell/list.do")
	public ModelAndView getList() {
		List<SellItem> list = this.sellService.getSellList();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sell/sell_list");
		mav.addObject("list", list);
		return mav;
	}
}
