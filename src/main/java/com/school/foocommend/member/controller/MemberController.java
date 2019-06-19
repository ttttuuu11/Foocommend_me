package com.school.foocommend.member.controller;

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

import com.school.foocommend.common.CommandMap;
import com.school.foocommend.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "MemberService")
	private MemberService memberService;
	
	@RequestMapping(value = "/login")
	public ModelAndView MemberLogin() throws Exception {
		ModelAndView mv = new ModelAndView("/member/viewLogin");
		List<Map<String, Object>> list = memberService.selectBoardList();
		
		
		 mv.addObject("list", list);
		return mv;
	}

	@RequestMapping(value = "/loginMem", method = RequestMethod.POST)
	public ModelAndView loginMem(@RequestParam(value = "error", required = false) String error,
								@RequestParam(value = "logout", required = false) String logout) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (error != null) {
			mv.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			mv.addObject("msg", "You've been logged out successfully.");
		}
		mv.setViewName("/board/main");
		return mv;
	}

	@RequestMapping(value = "/joinMem")
	public ModelAndView joinMem(CommandMap commandMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/member/join");
		// memberService.insertStudyBoard(commandMap.getMap());
		return mv;
	}

}
