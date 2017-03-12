package ru.filestorage.project.mongo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan("ru.filestorage.*")
@PropertySource("classpath:mongo.properties")
public class MongoDBConfig extends AbstractMongoConfiguration {

	@Autowired
	private Environment env;

	@Override
	protected String getDatabaseName() {
		return env.getProperty("mongoName");
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(env.getProperty("mongoURL"));
	}

	@Bean
	public SimpleMongoDbFactory mongoDbFactory() throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(), getDatabaseName());
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
