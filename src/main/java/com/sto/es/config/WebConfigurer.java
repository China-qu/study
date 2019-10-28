package com.sto.es.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.sto.es.intercept.LoginIntercept;

@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {
	
	@Autowired
	private LoginIntercept loginIntercept;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginIntercept).addPathPatterns("/**").excludePathPatterns("/login", "/register");
        super.addInterceptors(registry);    
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		super.addResourceHandlers(registry);
	}
}
