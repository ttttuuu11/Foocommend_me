package com.school.foocommend.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

//    resources/mybatis/mappers/member_sql 에서 구현됨.
@Mapper
public interface MemberDAO {
	public List<Map<String, Object>> selectBoardList() throws Exception;
}
