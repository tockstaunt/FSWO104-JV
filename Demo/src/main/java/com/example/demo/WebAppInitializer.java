package com.example.demo;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	// Map DispatcherServlet to "/"
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	// Load Java beans from WebConfig class for DispatcherServlet
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	// Load Java beans from RootConfig class for ContextLoaderListener
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}
}