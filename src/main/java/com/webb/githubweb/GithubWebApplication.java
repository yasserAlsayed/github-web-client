package com.webb.githubweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GithubWebApplication extends SpringBootServletInitializer implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}
	
	
	@Bean
	public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GithubWebApplication.class, args);
	}
	
	  @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/"); 
	  }
	 

}
