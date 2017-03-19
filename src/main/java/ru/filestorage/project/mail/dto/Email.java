package ru.filestorage.project.mail.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.http.annotation.Immutable;

/**
 * Простое dto, представляющее собой email-сообщение, имеющее адрес назначения и
 * текст сообщения.
 * 
 * @author Alimurad A. Ramazanov
 * @since 14.03.2017
 * @version 1.0.0
 *
 */
@Immutable
public class Email {

	@NotNull
	@Size(min = 3)
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	private String address;

	@NotNull
	private String text;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Email(String address, String text) {
		super();
		this.address = address;
		this.text = text;
	}
}
