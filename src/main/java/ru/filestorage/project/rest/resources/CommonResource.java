package ru.filestorage.project.rest.resources;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.google.common.base.Objects;

import ru.filestorage.project.mongo.entities.Entity;

@JsonSerialize(include = Inclusion.NON_NULL)
public class CommonResource implements Serializable {

	public String size;
	public String extension;
	public String fileName;
	public String id;
	public LocalDate createdDate;
	public String fileHref;

	private static final long serialVersionUID = 1L;

	public CommonResource(Map<String, String> parameters) {
		initResource(parameters);
	}

	@JsonCreator
	public CommonResource(@JsonProperty("size") String size, @JsonProperty("extension") String extension,
			@JsonProperty("fileName") String fileName, @JsonProperty("id") String id,
			@JsonProperty("createdDate") LocalDate createdDate, @JsonProperty("fileHref") String fileHref) {
		this.size = size;
		this.extension = extension;
		this.fileName = fileName;
		this.id = id;
		this.createdDate = createdDate;
		this.fileHref = fileHref;
	}

	public CommonResource(Entity entity) {
		this.size = Long.toString(entity.getSize());
		this.extension = entity.getExtension();
		this.fileName = entity.getFileName();
		this.id = entity.getUNID();
		this.createdDate = entity.getCreatedDate();
		this.fileHref = null;// TODO
	}

	private void initResource(Map<String, String> parameters) {
		Stream.of(this.getClass().getDeclaredFields()).forEach(field -> {
			try {
				field.set(this,
						parameters.entrySet().stream().filter(param -> Objects.equal(param.getKey(), field.getName()))
								.limit(1).findFirst().orElseGet(null));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		});
	}
}
