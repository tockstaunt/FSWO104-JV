package com.keithcollier.finalProject;

import org.springframework.web.bind.annotation.RequestMapping;

public class IndexController {
	
	// Request for multiple endpoints
	@RequestMapping(value= {"/", "/index"})
	public String Index() {
		return "index";
	}
}


