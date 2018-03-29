package com.keithcollier.lesson3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "/home", "/homepage",})
public class HomeController {
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	@RequestMapping("/beginning")
	public String beginning() {
		return "beginning";
	}
	
	@RequestMapping("/middle")
	public String middle() {
		return "middle";
	}
	
	@RequestMapping("/end")
	public String end() {
		return "end";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String homeSubmit(@ModelAttribute HomeModel model) {
		return "result";
	}
}