package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MemberShipVO;


@Repository
public class MemberMapper {
	
	@Autowired
	private SqlSession session;
	
	public List<MemberShipVO> selectList(MemberShipVO memberShipVO){
		return session.selectList("member.selectList");
	}

	/**
	 * 회원 정보
	 * @param memberVO
	 * @return
	 */
	public MemberShipVO selectOne(MemberShipVO memberShipVO) {
		return session.selectOne("member.selectOne", memberShipVO);
	}
	
	/**
	 * 회원 탈퇴 처리
	 * @param idx
	 */
	public void memberDrop(MemberShipVO memberShipVO) {
		session.update("member.memberDrop", memberShipVO);
	}
	
	/**
	 * 아이디 중복 체크
	 * @param userID
	 * @return
	 */
	public int checkUserID(String userID) {
		return session.selectOne("member.checkUserID", userID);
	}
	
	/**
	 * email 중복 체크
	 * @param userID
	 * @return
	 */
	public int checkEmail(String email) {
		return session.selectOne("member.checkEmail", email);
	}	
	
	/**
	 * 회원정보 변경
	 * @param memberVO
	 */
	public void updateInfo(MemberShipVO memberShipVO) {
		session.update("member.updateInfo", memberShipVO);
	}
}
