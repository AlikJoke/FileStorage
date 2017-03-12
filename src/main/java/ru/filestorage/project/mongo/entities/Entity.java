package ru.filestorage.project.mongo.entities;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mongodb.gridfs.GridFS;

/**
 * Интерфейс верхнего уровня для всех сущностей, хранимых в mongoDB.
 * 
 * @author Alimurad A. Ramazanov
 * @since 12.03.2017
 * @version 1.0.0 *
 *
 */
public interface Entity {

	/**
	 * Возвращает уникальный идентификатор сущности. Генерируется при создании
	 * сущности.
	 * <p>
	 * 
	 * @see UUID
	 * 
	 * @throws ValidationException
	 * @return не может быть {@code null}.
	 */
	@NotNull
	@Size(min = 1)
	String getUNID();

	/**
	 * Возвращает дату загрузки сущности в хранилище. Определяется при создании
	 * сущности.
	 * <p>
	 * 
	 * @see LocalDate
	 * 
	 * @throws ValidationException
	 * @return не может быть {@code null}.
	 */
	@NotNull
	LocalDate getCreatedDate();

	/**
	 * Возвращает размер хранимой сущности в байтах.
	 * <p>
	 * 
	 * @throws ValidationException
	 * @return не может быть {@code null}.
	 */
	@NotNull
	Long getSize();

	/**
	 * Возвращает имя файла, который воплощает сущность.
	 * <p>
	 * 
	 * @throws ValidationException
	 * @return не может быть {@code null}.
	 */
	@NotNull
	@Size(min = 1, max = 256)
	String getFileName();

	/**
	 * Возвращает расширение файла, который воплощает сущность.
	 * <p>
	 * 
	 * @throws ValidationException
	 * @return не может быть {@code null}.
	 */
	@NotNull
	@Size(min = 1, max = 256)
	String getExtension();

	/**
	 * Возвращает файл, который воплощает сущность. Хранится отдельно, в гриде.
	 * <p>
	 * 
	 * @see GridFS
	 * @see File
	 * 
	 * @throws ValidationException
	 * @return не может быть {@code null}.
	 */
	@NotNull
	File getFile();
}
