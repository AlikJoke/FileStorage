package ru.filestorage.project.activemq.configuration;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsTemplate;

import ru.filestorage.project.mail.utils.MailUtils;

@Configuration
@EnableJms
public class JmsConfiguration {

	@Bean
	public ConnectionFactory jmsConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
				"tcp://localhost:8080?broker.persistent=false");
		connectionFactory.setObjectMessageSerializationDefered(true);
		connectionFactory.setCopyMessageOnSend(false);

		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
		return cachingConnectionFactory;
	}

	@Bean
	public JmsTemplate JmsTemplate() {
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(jmsConnectionFactory());
		jmsTemplate.setDefaultDestination(new ActiveMQQueue(MailUtils.DESTINATION));
		jmsTemplate.setSessionTransacted(true);
		jmsTemplate.setReceiveTimeout(2000);
		return jmsTemplate;
	}

	@Bean(name = "jmsTransactionManager")
	public JmsTransactionManager jmsTransactionManager() {
		return new JmsTransactionManager(jmsConnectionFactory());
	}

}
