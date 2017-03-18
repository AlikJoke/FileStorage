package ru.filestorage.project.context.configuration;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

/**
 * Интерфейс для работы с {@link ApplicationContext}.
 * 
 * @author Alimurad A. Ramazanov
 * @since 19.03.2017
 * @version 1.0.0
 *
 */
public interface ApplicationContextService {

	/**
	 * Определяет, содержится ли в контексте бин с заданным именем.
	 * <p>
	 * 
	 * @param beanName
	 *            - имя бина, не может быть {@code null} или {@literal ""}.
	 * @return {@code true} - если бин найден в контексте, {@code false} -
	 *         иначе.
	 */
	boolean containsBean(@NotNull @Size(min = 1) String beanName);

	/**
	 * Определяет, является ли бин с заданным именем одиночным.
	 * <p>
	 * 
	 * @param beanName
	 *            - имя бина, не может быть {@code null} или {@literal ""}.
	 * @return {@code true} - если бин является одиночным, {@code false} -
	 *         иначе.
	 */
	boolean isSingleton(@NotNull @Size(min = 1) String beanName);

	/**
	 * Определяет, имеет ли бин с заданным именем прототипом.
	 * <p>
	 * 
	 * @param beanName
	 *            - имя бина, не может быть {@code null} или {@literal ""}.
	 * @return {@code true} - если бин является прототипом, {@code false} -
	 *         иначе.
	 */
	boolean isPrototype(@NotNull @Size(min = 1) String beanName);

	/**
	 * Возвращает бин, если он содержится в контексте, по имени бина.
	 * <p>
	 * 
	 * @param beanName
	 *            - имя бина, не может быть {@code null} или {@literal ""}.
	 * @param params
	 *            - список параметров, может быть пустым.
	 * @return бин, если он найден в контексте, может быть {@code null},
	 */
	Object getBean(@NotNull @Size(min = 1) String beanName, Object... params);

	/**
	 * Возвращает бин, если он содержится в контексте, по классу бина.
	 * <p>
	 * 
	 * @param beanClass
	 *            - класс бина, не может быть {@code null}.
	 * @param params
	 *            - список параметров, может быть пустым.
	 * @return бин, если он найден в контексте, может быть {@code null},
	 */
	<T> T getBean(@NotNull Class<T> beanClass, Object... params);

	/**
	 * Возвращает сообщение, если оно есть в настройках messageSource.
	 * <p>
	 * 
	 * @param messageKey
	 *            - ключ сообщения, не может быть {@code null}.
	 * @param args
	 *            - список дополнительных аргументов (опционально).
	 * @return не может быть {@code null}; если сообщение с данным ключом
	 *         отсутствует, то выдается "дефолтное".
	 */
	@NotNull
	String getMessage(String messageKey, Object... args);

	/**
	 * Возвращает ресурс по его URL.
	 * <p>
	 * 
	 * @param location
	 *            - URL бина в виде строки в правильном формате (с
	 *            {@code ftp://}, {@code http://} и т. д.)
	 * @return может быть {@code null}, если запрашиваемый ресурс недоступен.
	 */
	Resource getResource(String location);
}
