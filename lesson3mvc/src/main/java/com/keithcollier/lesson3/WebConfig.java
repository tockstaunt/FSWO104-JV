package com.keithcollier.lesson3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration  // mark as configuration class
@EnableWebMvc   // enable Spring MVC
@ComponentScan("com.keithcollier") // enable component scanning in the "com.keithcollier" package
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// views are in the folder "/WEB-INF/views/"
		viewResolver.setPrefix("/WEB-INF/views/");
		// all view files are HTML documents
		viewResolver.setSuffix(".html");
		viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}

	@Override
	// configure static file handling
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // DispatcherServlet: forward requests for static resources to the default servlet
        // requests for static resources are forwarded to the default servlet
		configurer.enable();
	}
}