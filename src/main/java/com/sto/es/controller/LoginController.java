package com.sto.es.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class LoginController extends WebMvcConfigurerAdapter {
	
	@Override
   public void addViewControllers( ViewControllerRegistry registry ) {
       registry.addViewController( "/" ).setViewName( "forward:/index.html" );
       registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
       super.addViewControllers( registry );
   }

}
