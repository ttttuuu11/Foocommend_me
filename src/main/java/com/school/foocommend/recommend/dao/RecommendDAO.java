package com.school.foocommend.recommend.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

//    resources/mybatis/mappers/member_sql 에서 구현됨.

@Mapper
public interface RecommendDAO {
	public Map<String, Object> selectRestaurantList(String idx) throws Exception;
}
