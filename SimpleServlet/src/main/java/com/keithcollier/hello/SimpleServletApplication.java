package com.keithcollier.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SimpleServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleServletApplication.class, args);
	}
}
