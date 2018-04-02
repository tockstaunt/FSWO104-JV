package com.keithcollier.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Post {
	@Id
	@GeneratedValue
	private Long id;
	
	private String posterName;
	private String posterMessage;
	
	protected Post() {
		
	}
	
	public Post(String name, String message) {
		this.posterName = name;
		this.posterMessage = message;
	}
	
	public Long getId() {
		return id;
		}

	public String getPosterName(String posterName) {
		return posterName;
	}

	public String getPosterMessage() {
		return posterMessage;
	}

	public void setPostMessage(String posterMessage) {
		this.posterMessage = posterMessage;
	}
	
	@Override
	public String toString() {
		return String.format("Post[id=%d, posterName='%s', posterMessage='%s']", id, posterName, posterMessage);
	}

}
