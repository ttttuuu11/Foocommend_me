package com.school.foocommend.board.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.school.foocommend.board.vo.RestaurantDto;

@Mapper
public interface RestaurantDao {
	public RestaurantDto selectRestaurant(String restaurantIdx) throws Exception;
}
