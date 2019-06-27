package com.school.foocommend.board.vo;

import lombok.Data;

@Data
public class RestaurantDto {

	private Integer restaurant_idx;
	private String restaurant_area;
	private String restaurant_title;
	private String restaurant_food_kind;
	private String restaurant_land_add;
	private String restaurant_streed_add;
	private float restaurant_latitude;
	private float restaurant_longitude;
	private String restaurant_menu;
	
}
