package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.vo.MemberShipVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class DafaultController {
	
	@GetMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		MemberShipVO memberInfo = (MemberShipVO) session.getAttribute("userInfo");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("common/index");
		mav.addObject("title", "인텍스 페이지");
				
		return mav;
	}
	
	
}

