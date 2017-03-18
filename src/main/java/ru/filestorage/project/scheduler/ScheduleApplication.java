package ru.filestorage.project.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import ru.filestorage.project.activemq.configuration.JmsConfiguration;
import ru.filestorage.project.mail.service.EmailService;

@Configuration
@Import(JmsConfiguration.class)
@EnableScheduling
@PropertySource("classpath:schedules.properties")
public class ScheduleApplication {

	@Value("${address}")
	private String address;

	@Value("${message}")
	private String message;

	@Autowired
	private EmailService emailService;

	@Scheduled(initialDelay = 10000, fixedDelay = 1000)
	public void scheduledSend() {
		emailService.send(address, message);
	}
	
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
       return new PropertySourcesPlaceholderConfigurer();
    }
}
