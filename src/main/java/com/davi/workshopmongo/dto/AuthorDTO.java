package com.davi.workshopmongo.dto;

import java.io.Serializable;

import com.davi.workshopmongo.domain.User;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}
	
	public AuthorDTO() {
		
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
	
	
}
