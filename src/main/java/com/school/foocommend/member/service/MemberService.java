package com.school.foocommend.member.service;

import java.util.List;
import java.util.Map;


public interface  MemberService {
	List<Map<String, Object>> selectBoardList() throws Exception;
}
