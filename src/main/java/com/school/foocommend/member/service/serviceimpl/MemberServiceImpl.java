package com.school.foocommend.member.service.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.foocommend.member.dao.MemberDao;
import com.school.foocommend.member.service.MemberService;
import com.school.foocommend.member.vo.UserDto;


@Service("MemberService")
@Transactional
public class MemberServiceImpl implements MemberService{

//	@Resource(name = "memberDAO")
//	private MemberDAO memberDAO;
	
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public List<Map<String, Object>> selectBoardList() throws Exception {
		return memberDao.selectBoardList();
	}

	@Override
	public UserDto selectMember(String username) throws Exception {

		return memberDao.selectMember(username);
	}
	
}
