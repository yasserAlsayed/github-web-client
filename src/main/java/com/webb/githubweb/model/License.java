package com.webb.githubweb.model;

import java.io.Serializable;

public class License implements Serializable {
	private static final long serialVersionUID = -8022002609514542998L;
	
	private String key;
	private String name;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return key;
	}
	
	

}
