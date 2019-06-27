package com.school.foocommend.recommend.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.foocommend.member.dao.MemberDao;
import com.school.foocommend.member.service.MemberService;
import com.school.foocommend.recommend.dao.RecommendDao;
import com.school.foocommend.recommend.service.RecommendService;


@Service("RecommendService")
@Transactional
public class RecommendServiceImpl implements RecommendService{

//	@Resource(name = "memberDAO")
//	private MemberDAO memberDAO;
	
	@Autowired
	private RecommendDao recommendDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectRestaurantList(List<Map<String, Object>> resultRecommendList) throws Exception{
		List<Map<String, Object>> restaurantIntroList = new ArrayList<Map<String, Object>>();
		 for( Map<String, Object> restaurantItem : resultRecommendList ){
			 Integer idx = Integer.parseInt(restaurantItem.get("store_number").toString())+2;
			 restaurantIntroList.add((Map<String, Object>) recommendDAO.selectRestaurantList(idx.toString()));
		 }
		return restaurantIntroList;
	}
	
}
