package ru.filestorage.project.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import ru.filestorage.project.mail.dto.Email;
import ru.filestorage.project.mail.service.EmailService;
import ru.filestorage.project.mail.utils.MailUtils;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public void send(final String address, final String message) {
		Email email = new Email(address, message);
		jmsTemplate.convertAndSend(MailUtils.DESTINATION, email);
	}
}
