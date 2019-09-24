package com.webb.githubweb.model;

import java.io.Serializable;
import java.util.List;

public class RepoResult implements Serializable {
	private static final long serialVersionUID = 4115606245138408615L;
	
	private int total_count  ;
	private List<Repo> items;
	
	public int getTotal_count() {
		return total_count;
	}

	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	public List<Repo> getItems() {
		return items;
	}

	public void setItems(List<Repo> items) {
		this.items = items;
	}
}
