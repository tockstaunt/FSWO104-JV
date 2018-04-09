package com.keithcollier.post;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration

// scan for components in the "com.example.demo" package and exclude a selected portion
@ComponentScan(
    basePackages= { "com.keithcollier.post" },
    excludeFilters= { @Filter( type=FilterType.ANNOTATION, value=EnableWebMvc.class)}
)

public class RootConfig {

}