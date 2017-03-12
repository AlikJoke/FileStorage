package ru.filestorage.project.mongo.entities;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Сущность аудиозаписи, хранимая в mongoDB.
 * 
 * @author Alimurad A. Ramazanov
 * @since 12.03.2017
 * @version 1.0.0
 *
 */
@Document(collection = "audio")
public class Audio extends MongoEntity {

	@Field("duration")
	@NotNull
	private Long duration;

	@Field("duration")
	private Set<String> performers;

	@Field("rating")
	private Integer rating;

	public Audio(Long duration, Set<String> performers, Integer rating, Long size, 
			String extension, String fileName) {
		super(size, extension, fileName);
		this.duration = duration;
		this.performers = performers;
		this.rating = rating;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Set<String> getPerformers() {
		return performers;
	}

	public void setPerformers(Set<String> performers) {
		this.performers = performers;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
