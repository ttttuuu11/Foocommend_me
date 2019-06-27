package com.school.foocommend.board.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.foocommend.board.service.RestaurantService;
import com.school.foocommend.board.vo.RestaurantDto;
import com.school.foocommend.recommend.service.RecommendService;
import com.school.foocommend.socket.Client;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board")
public class BoardController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "RestaurantService")
	private RestaurantService restaurantService;
	

	@RequestMapping(value = "/main")
	public ModelAndView BoardList(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/viewMain");

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = (UserDetails) principal;
		String username = userDetails.getUsername();
		String password = userDetails.getPassword();

		log.info(username);
		log.info(password);
		
		
		mv.addObject("username",username);
		mv.addObject("password",password);
		
		return mv;
	}

	@RequestMapping(value = "/survey")
	public ModelAndView SurveyRecommend(Map<String, Object> commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("/board/surveyRecommend");

		File folder = new File("D:\\workspace\\resources\\foocommend\\survey_image");
		File[] listOfFiles = folder.listFiles();

		List<String> filesNameList = new ArrayList<String>();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				filesNameList.add(listOfFiles[i].getName());
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}

		mv.addObject("filesNameList", filesNameList);
		mv.addObject("upValue", Math.ceil(100 / filesNameList.size()));
		return mv;
	}
	
	@RequestMapping(value = "/detail")
	public ModelAndView RestaurantDetail(Map<String, Object> commandMap,  @RequestParam(value = "restaurantIdx", required = false) String restaurantIdx ) throws Exception {
		ModelAndView mv = new ModelAndView("/board/viewDetail");
		RestaurantDto restaurant = restaurantService.selectRestaurant(restaurantIdx);

		mv.addObject("restaurant",restaurant);
		return mv;
	}

}
