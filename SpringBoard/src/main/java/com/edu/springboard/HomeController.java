package com.edu.springboard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/api/landingpage", method = RequestMethod.GET)
	@ResponseBody
	public String home(HttpServletRequest req) {
		String test = req.getParameter("test");
		
		return test;
	}
	
}
