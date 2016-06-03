package com.julie.mikaelson.config;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebBean extends WebMvcConfigurerAdapter {
	protected Log logger = LogFactory.getLog(getClass()); // Don't initialize early
	
	/**
	 *
	 * @return registrationBean with Utf-8 encoding config
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		logger.info("-----------------------------------filterRegistrationBean set UTF-8-----------------------------------------");
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		registrationBean.setFilter(characterEncodingFilter);
		return registrationBean;
	}
	/**
	 * Configures the message source bean.
	 */
	@Bean
	public MessageSource messageSource() {
		logger.info("-----------------------------------messageSource invoke-----------------------------------------");
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages");
		messageSource.setUseCodeAsDefaultMessage(true);
		return messageSource;
	}
	
	/*@Bean
	public InternalResourceViewResolver setupInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		logger.info("-----------------------------------setupInternalResourceViewResolver invoke-----------------------------------------");
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}*/
	
	/**
	 * local resolver with default value (CHINA)
	 * 
	 * @return local resolver
	 */
	@Bean
	public LocaleResolver localeResolver() {
		logger.info("-----------------------------------localeResolver invoke-----------------------------------------");
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.CHINA);
		return slr;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	/**
	 * 
	 * @return localchangeinterceptor for app
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	
}