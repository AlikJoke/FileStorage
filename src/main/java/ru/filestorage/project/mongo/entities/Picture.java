package ru.filestorage.project.mongo.entities;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Сущность картинки, хранимая в mongoDB.
 * 
 * @author Alimurad A. Ramazanov
 * @since 12.03.2017
 * @version 1.0.0
 *
 */
@Document(collection = "picture")
public class Picture extends MongoEntity {

	@Field("height")
	@NotNull
	private Integer height;

	@Field("width")
	@NotNull
	private Integer width;

	public Picture(Integer height, Integer width, Long size, String extension, String fileName) {
		super(size, extension, fileName);
		this.height = height;
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}
}
