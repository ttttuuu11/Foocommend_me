package com.school.foocommend.member.service;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.User;

import com.school.foocommend.member.vo.UserDto;


public interface MemberService {
	List<Map<String, Object>> selectBoardList() throws Exception;
	
	UserDto selectMember(String username) throws Exception;
}
