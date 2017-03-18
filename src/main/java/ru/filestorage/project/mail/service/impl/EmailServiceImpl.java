package ru.filestorage.project.mail.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import ru.filestorage.project.context.configuration.ApplicationContextService;
import ru.filestorage.project.mail.dto.Email;
import ru.filestorage.project.mail.service.EmailService;
import ru.filestorage.project.mail.utils.MailUtils;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Resource(name = "appCtxHolder")
	private ApplicationContextService appCtxService;

	@PostConstruct
	public void init() {
		if (jmsTemplate == null)
			throw new IllegalStateException(appCtxService.getMessage("notInjectedBean"));
	}

	public void send(final String address, final String message) {
		Email email = new Email(address, message);
		jmsTemplate.convertAndSend(MailUtils.DESTINATION, email);
	}
}
