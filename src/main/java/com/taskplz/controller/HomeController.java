package com.taskplz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "pages/home";
	}
	
	//Auth for cert
	@RequestMapping(value = "/.well-known/acme-challenge/br0GeUIZ9sGqI1ZwBbtzF6KZKH34YIt28x2C8YcbphE", method = RequestMethod.GET)
	public String certAuthorize() {
		return "pages/certauth";
	}
	@RequestMapping(value = "/.well-known/acme-challenge/NJUZGnjIAs4ZWdeaa01Y2za5b8uuL7YoLX-2sclmJrY", method = RequestMethod.GET)
	public String certAuthorizewww() {
		return "pages/certauthwww";
	}
	
	

}
