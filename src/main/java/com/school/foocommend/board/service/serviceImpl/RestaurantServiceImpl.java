package com.school.foocommend.board.service.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.foocommend.board.dao.RestaurantDao;
import com.school.foocommend.board.service.RestaurantService;
import com.school.foocommend.board.vo.RestaurantDto;
import com.school.foocommend.recommend.dao.RecommendDao;

@Service("RestaurantService")
@Transactional
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantDao restaurantDao;
	
	
	@Override
	public RestaurantDto selectRestaurant(String restaurantIdx) throws Exception {
		return restaurantDao.selectRestaurant(restaurantIdx);
	}
}
