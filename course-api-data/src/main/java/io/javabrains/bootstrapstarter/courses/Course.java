package io.javabrains.bootstrapstarter.courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.javabrains.bootstrapstarter.topics.topic;

@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String description;
	@ManyToOne
	private topic topic;
	
	
	public Course() {
		
	}
	
	public Course(String id, String name, String description, String topicID) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new topic(topicID, "", "");
	}
	
	
	public topic getTopic() {
		return topic;
	}

	public void setTopic(topic topic) {
		this.topic = topic;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
