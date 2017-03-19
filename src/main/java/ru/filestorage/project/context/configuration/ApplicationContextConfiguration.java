package ru.filestorage.project.context.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:message-configuration.properties")
public class ApplicationContextConfiguration {

	@Value("${defaultMsg}")
	private String defaultMsg;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean(name = "defaultMessage")
	public String getDefaultMessage() {
		return defaultMsg;
	}
}
