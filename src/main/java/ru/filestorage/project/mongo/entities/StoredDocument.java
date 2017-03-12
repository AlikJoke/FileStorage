package ru.filestorage.project.mongo.entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Сущность документа, хранимого в mongoDB.
 * 
 * @author Alimurad A. Ramazanov
 * @since 12.03.2017
 * @version 1.0.0
 *
 */
@Document(collection = "document")
public class StoredDocument extends MongoEntity {

	@Field("author")
	private String author;

	public StoredDocument(String author, Long size, String extension, String fileName) {
		super(size, extension, fileName);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
