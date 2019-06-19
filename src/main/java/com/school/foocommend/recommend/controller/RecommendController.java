package com.school.foocommend.recommend.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.school.foocommend.socket.Client;

@Controller
@RequestMapping("/recommend")
public class RecommendController {

	Logger log = LoggerFactory.getLogger(this.getClass());


	@RequestMapping(value = "/recommendData")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/recommend/recommendPage");

		Client client = new Client("도현카페");
		List<Map<String, Object>> resultRecommendList = client.getResult();

		mv.addObject("resultRecommendList", resultRecommendList);

		return mv;
	}
}
