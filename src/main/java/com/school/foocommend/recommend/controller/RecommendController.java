package com.school.foocommend.recommend.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.foocommend.member.service.MemberService;
import com.school.foocommend.recommend.service.RecommendService;
import com.school.foocommend.socket.Client;

@Controller
@RequestMapping("/recommend")
public class RecommendController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "RecommendService")
	private RecommendService recommendService;
	
	@RequestMapping(value = "/recommendRestaurant", method = RequestMethod.POST)
	public ModelAndView recommendRestaurant(Map<String, Object> menuMap, @RequestParam(value = "myMenu", required = false) String myMenu)
			throws Exception {
		ModelAndView mv = new ModelAndView("/board/viewRecommend");

		
		int comIdx = myMenu.indexOf(",");
		String menu = myMenu.substring(0,comIdx);
		log.info(menu);
				
		Client client = new Client(menu); // 데이터베이스에서 소재지지번주소
		// 갖고오기
		List<Map<String, Object>> resultRecommendList = client.getResult();
		List<Map<String, Object>> restaurantIntroList = recommendService.selectRestaurantList(resultRecommendList);

		mv.addObject("resultRecommendList", resultRecommendList);
		mv.addObject("restaurantIntroList", restaurantIntroList);

		return mv;
	}
}
