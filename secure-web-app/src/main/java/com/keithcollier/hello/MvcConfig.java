package com.keithcollier.hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addViewControllers(ViewControllerRegistry register) {
		//binds home to 8080/home
		register.addViewController("/home").setViewName("home");
		//binds / to home
		register.addViewController("/").setViewName("home");
		//binds 8080/hello to hello view
		register.addViewController("/hello").setViewName("hello");
		//binds 8080/login to login
		register.addViewController("/login").setViewName("login");
	}

}
