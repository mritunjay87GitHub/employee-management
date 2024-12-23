package com.mks.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mks.entity.UserAuthentication;
import com.mks.exception.ResponseHeaderException;

@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		try {
			mav.setViewName("authentication/login");
			mav.addObject("userAuthentication", new UserAuthentication());
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Unable to login due to validation not passed, Please Try Again !!!");
		}

		return mav;

	}
}
