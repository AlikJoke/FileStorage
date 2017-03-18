package ru.filestorage.project.context.configuration;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component("appCtxHolder")
@Scope("singleton")
@Configurable
public class ApplicationContextHolderImpl implements ApplicationContextAware, ApplicationContextService {

	private ApplicationContext context;

	@Qualifier("defaultMessage")
	private String defaultMsg;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Override
	public boolean containsBean(String beanName) {
		return context.containsBean(beanName);
	}

	@Override
	public boolean isSingleton(String beanName) {
		return context.isSingleton(beanName);
	}

	@Override
	public boolean isPrototype(String beanName) {
		return context.isPrototype(beanName);
	}

	@Override
	public Object getBean(@NotNull @Size(min = 1) String beanName, Object... params) {
		if (params.length == 0)
			return context.getBean(beanName);

		return context.getBean(beanName, params);
	}

	@Override
	public <T> T getBean(@NotNull @Size(min = 1) Class<T> beanClass, Object... params) {
		if (params.length == 0)
			return context.getBean(beanClass);

		return context.getBean(beanClass, params);
	}

	@Override
	public String getMessage(String messageKey, Object... args) {
		return context.getMessage(messageKey, args, defaultMsg, LocaleContextHolder.getLocale());
	}

	@Override
	public org.springframework.core.io.Resource getResource(String location) {
		return context.getResource(location);
	}

}
