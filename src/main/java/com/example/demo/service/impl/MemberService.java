package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.payload.request.DropRequest;
import com.example.demo.service.CrudService;
import com.example.demo.vo.MemberShipVO;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Service
public class MemberService implements CrudService<MemberShipVO> {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<MemberShipVO> selectList(MemberShipVO e) {
		return mapper.selectList(e);
	}
	@Override
	public MemberShipVO selectOne(MemberShipVO e) {
		return mapper.selectOne(e);
	}
		
	public MemberShipVO selectOne(String userID, String password) {
		MemberShipVO vo = new MemberShipVO();
		vo.setUserID(userID);
		vo.setPassword(password);
		return mapper.selectOne(vo);
	}
		
	@Override
	public void insert(MemberShipVO e) {
		
	}
	@Override
	public void update(MemberShipVO e) {
		
	}
	@Override
	public void delete(MemberShipVO e) {
		
	}
	/**
	 * 회원 탈퇴
	 * @param dropRequest
	 * @return
	 */
	public boolean memberDrop(String userID, String password) {
		int cnt = mapper.checkUserID(userID);
		if (cnt == 0) {
	        // 사용자 ID가 존재하지 않는 경우 예외 발생
	        return false;
	    } 
		MemberShipVO vo = new MemberShipVO();
		vo.setUserID(userID);
		vo.setPassword(password);
		mapper.memberDrop(vo);
	    return true;
	}
	
	/**
	 * 회원정보 수정
	 * @param request
	 * @param memberVO
	 * @return
	 */
	public boolean updateInfo(HttpServletRequest request, MemberShipVO memberShipVO) {
		HttpSession session = request.getSession();
		MemberShipVO userInfo = (MemberShipVO) session.getAttribute("userInfo");
		
		if (userInfo == null) {
			return false;
		}
		
		// pk값이 세션에 있는거랑 다르면 로직을 추가할 수도 있다.
		if (!memberShipVO.getIdx().equals(userInfo.getIdx()) ) {
			return false;
		}
		
		// 세션에 있는 userID와 파라미터로 넘어온 userID가 다르면 이 역시 로직을 추가하는 것도 방법이다.
		if (!memberShipVO.getUserID().equals(userInfo.getUserID())) {
			return false;
		}
		
		if (!memberShipVO.getPassword().equals("")) {
			memberShipVO.setPassword("");
		}
		
		mapper.updateInfo(memberShipVO);
		
		return true;
	}
	

}
