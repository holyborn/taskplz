package com.taskplz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserVController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserVController.class);

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView signin(){
		ModelAndView mv = new ModelAndView("pages/signin");
		return mv;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(){
		ModelAndView mv = new ModelAndView("pages/signup");
		return mv;
	}
}
