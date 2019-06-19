package com.school.foocommend.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;		
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.foocommend.socket.Client;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board")
public class BoardController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
		
//	@Resource(name = "boardService")
//	private BoardService boardService;

	@RequestMapping(value = "/main")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/viewMain");
		
		Client client = new Client("경기도 부천시 심곡동 160-1번지 1층 일부"); //데이터베이스에서 소재지지번주소 갖고오기
		System.out.println("클라이언트 생성");
		List<Map<String, Object>> resultRecommendList = client.getResult();		
		
		mv.addObject("resultRecommendList", resultRecommendList);

		return mv;
	}

	
	
	@RequestMapping(value = "/survey")
	public ModelAndView SurveyRecommend(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/surveyRecommend");
		return mv;
	}

	
}
