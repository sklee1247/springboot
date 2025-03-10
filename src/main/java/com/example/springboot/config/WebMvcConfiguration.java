package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import com.example.springboot.interceptor.MyInterceptor;

@EnableWebMvc
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// @formatter:off
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("classpath:/resources/")
				.setCachePeriod(31556926);
		registry.addResourceHandler("/favicon.ico")
	            .addResourceLocations("classpath:/resources/");
	    registry.addResourceHandler("/js/**")
	            .addResourceLocations("classpath:/static/js/");
	    registry.addResourceHandler("/css/**")
	            .addResourceLocations("classpath:/static/css/");
	    registry.addResourceHandler("/images/**")
	            .addResourceLocations("classpath:/static/images/");
	    registry.addResourceHandler("/assets/**")
        		.addResourceLocations("classpath:/static/assets/");
	    registry.addResourceHandler("/vendor/**")
	    		.addResourceLocations("classpath:/static/vendor/");
		// @formatter:on
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new MyInterceptor())  // Add your custom interceptor
	            .addPathPatterns("/**")  // Apply to all URLs
	            .excludePathPatterns("/login", "/index", "/js/**", "/css/**", "/images/**", "/assets/**", "/vendor/**");  // Exclude specific paths
	}
	
	@Bean
	public ViewResolver viewResolver(ISpringTemplateEngine templateEngine) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine);
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}

//	@Bean
//	public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
//		SpringTemplateEngine engine = new SpringTemplateEngine();
//		engine.setEnableSpringELCompiler(true);
//		engine.setTemplateResolver(templateResolver);
//		return engine;
//	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("classpath:/templates/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode(TemplateMode.HTML);
		return resolver;
	}
}