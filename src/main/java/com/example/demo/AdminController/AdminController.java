package com.example.demo.AdminController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.service.impl.MemberService;
import com.example.demo.vo.MemberShipVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
	
	@Autowired 
	private MemberService memberService;
	
	@GetMapping("/memberList")
	public ModelAndView memberList(
			@ModelAttribute MemberShipVO memberShipVO
			) {
		List<MemberShipVO> list = memberService.selectList(memberShipVO);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/memberList");
		mav.addObject("title", "회원목록");
		mav.addObject("list", list);
		return mav;
	}
	
	
	
	
	

}
