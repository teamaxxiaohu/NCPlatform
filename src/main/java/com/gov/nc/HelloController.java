package com.gov.nc;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		DateTime dateTime = new DateTime();
		dateTime.getMinuteOfDay();
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
}