package com.keithcollier.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "/home", "/homepage"})
public class HomeController {
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String homeSubmit(@ModelAttribute HomeModel model) {
		return "result";
	}
}