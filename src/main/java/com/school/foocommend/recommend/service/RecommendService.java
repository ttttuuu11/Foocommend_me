package com.school.foocommend.recommend.service;

import java.util.List;
import java.util.Map;


public interface RecommendService {
	List<Map<String, Object>> selectRestaurantList(List<Map<String, Object>> resultRecommendList) throws Exception;
}
