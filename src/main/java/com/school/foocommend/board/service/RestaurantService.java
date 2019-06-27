package com.school.foocommend.board.service;

import java.util.List;
import java.util.Map;

import com.school.foocommend.board.vo.RestaurantDto;

public interface RestaurantService {
	RestaurantDto selectRestaurant(String restaurantIdx) throws Exception;
}
