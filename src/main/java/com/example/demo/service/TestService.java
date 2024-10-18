package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.mapper.StoreInfoMapper;
import com.example.demo.vo.StoreInfoVO;

@Service
public class TestService {

	@Autowired
	private StoreInfoMapper storeInfoMapper;
	
	public void insertItems(List<HashMap<String, Object>> items) {
		for (HashMap<String, Object> item : items) {
			storeInfoMapper.insertItems(item);
		}
	};
	

	public List<StoreInfoVO> selList(){
		return storeInfoMapper.selList();
	};
}
