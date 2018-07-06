package com.roberto.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


@Configuration
@EnableWebMvc
//@ComponentScan({"com.roberto.spring.controller", "com.roberto.spring.bean"})
@ComponentScan("com.roberto.spring.controller")
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	/*
	 * ApplicatonContext ,som är det centrala interfacet inom en Spring App, ger
	 * konfigurationinformation till Applikationen
	 */
	ApplicationContext applicationContext;

	//Setting the index page
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	} 

	//1. Creating SpringResourceTemplateResolver
	@Bean
	public SpringResourceTemplateResolver springTemplateResolver() {
		SpringResourceTemplateResolver springTemplateResolver = new SpringResourceTemplateResolver();
		springTemplateResolver.setApplicationContext(this.applicationContext);
		springTemplateResolver.setPrefix("/WEB-INF/");
		//springTemplateResolver.setPrefix("/WEB-INF/pages/");
		springTemplateResolver.setSuffix(".html");
		return springTemplateResolver;
	}

	//2. Creating SpringTemplateEngine
	@Bean
	public SpringTemplateEngine springTemplateEngine(){
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(springTemplateResolver());
		return springTemplateEngine;
	}

	//3. Registering ThymeleafViewResolver
	@Bean
	public ViewResolver viewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(springTemplateEngine());
		return viewResolver;
	}

	//4. Adding resources to project
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/css/**").addResourceLocations("/resources/css/");
		registry.addResourceHandler("/resources/js/**").addResourceLocations("/resources/js/");
		registry.addResourceHandler("/resources/img/**").addResourceLocations("/resources/img/");
	}


}
