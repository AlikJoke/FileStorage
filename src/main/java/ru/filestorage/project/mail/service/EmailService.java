package ru.filestorage.project.mail.service;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;

import org.springframework.jms.core.JmsTemplate;

/**
 * Сервис по отправке email-сообщений.
 * 
 * @author Alimurad A. Ramazanov
 * @since 14.03.2017
 * @version 1.0.0
 *
 */
public interface EmailService {

	/**
	 * Отправляет сообщение по заданному адресу и с заданными сообщением.
	 * <p>
	 * 
	 * @see JmsTemplate
	 * @param address
	 *            - адрес почты, не может быть {@code null}.
	 * @param message
	 *            - сообщение, может быть {@code ""}.
	 * @throws ValidationException
	 *             - если адрес не соответствует шаблону.
	 */
	void send(@NotNull String address, @NotNull String message);
}
