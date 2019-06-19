package com.school.foocommend.member.service.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.foocommend.member.dao.MemberDAO;
import com.school.foocommend.member.service.MemberService;


@Service("MemberService")
@Transactional
public class MemberServiceImpl implements MemberService{

//	@Resource(name = "memberDAO")
//	private MemberDAO memberDAO;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<Map<String, Object>> selectBoardList() throws Exception {
		return memberDAO.selectBoardList();
	}
	
}
