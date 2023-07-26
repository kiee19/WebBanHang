package com.PS11390_NguyenTungNhatLinh_ASM.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.PS11390_NguyenTungNhatLinh_ASM.interceptor.AuthenticationInterceptor;
import com.PS11390_NguyenTungNhatLinh_ASM.interceptor.CheckOutInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private AuthenticationInterceptor authenticationInterceptor;
	
	@Autowired
	private CheckOutInterceptor checkOutInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authenticationInterceptor).addPathPatterns("/admin/**");
		registry.addInterceptor(checkOutInterceptor).addPathPatterns("/checkout/**");
	}
	
}
