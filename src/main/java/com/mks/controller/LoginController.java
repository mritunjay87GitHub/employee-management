package com.mks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mks.entity.UserAuthentication;

@Controller
public class LoginController {

	@GetMapping("/login") 
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("authentication/login");
		mav.addObject("userAuthentication", new UserAuthentication());
		 return mav;
				
	}
}
