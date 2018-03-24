package com.keithcollier.lesson2handson;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Lesson2HandsOnApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson2HandsOnApplication.class, args);
	}
}