package com.woniuxy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RootConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") //
				.allowedOrigins("*") //
				.allowedMethods("*") //
<<<<<<< HEAD
				.allowedHeaders("*")
				.allowCredentials(true);
=======
				.allowedHeaders("Access-Control-Allow-Origin", "*")
				.allowCredentials(true)   //允许客户端跨域ajax携带cookie
				.maxAge(60);  
>>>>>>> branch 'dev' of git@github.com:zhangyan0215/paipai.git
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new Logs()).addPathPatterns("/**");
	}

}
