package ru.filestorage.project.mongo.entities;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Абстрактная сущность, представляющая из себя файл, хранимый в mongoDB. UNID -
 * уникальный идентификатор сущности в коллекции.
 * 
 * @author Alimurad A. Ramazanov
 * @version 1.0.0
 * @since 12.03.2017
 *
 */
public abstract class MongoEntity implements Entity {

	@Id
	@Field(value = "id")
	@NotNull
	private final String unid;

	@Field(value = "size")
	@NotNull
	private Long size;

	@Field(value = "extension")
	@NotNull
	@Indexed
	private String extension;

	@Field(value = "fileName")
	@NotNull
	@Indexed
	private String fileName;
	
	@Field(value = "createdDate")
	@NotNull
	@Indexed
	private final LocalDate createdDate;

	@Transient
	@NotNull
	private File file;

	public MongoEntity() {
		this.unid = UUID.randomUUID().toString();
		this.createdDate = LocalDate.now();
	}

	public MongoEntity(Long size, String extension, String fileName) {
		this();
		this.size = size;
		this.extension = extension;
		this.fileName = fileName;
	}

	@Override
	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String getUNID() {
		return unid;
	}

	@Override
	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	@Override
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	@Override
	public LocalDate getCreatedDate() {
		return this.createdDate;
	}

}
