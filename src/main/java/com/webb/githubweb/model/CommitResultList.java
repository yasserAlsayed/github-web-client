package com.webb.githubweb.model;

import java.io.Serializable;
import java.util.List;

public class CommitResultList implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2104248290076027148L;
	private List<CommitResult> commits;

	public List<CommitResult> getCommits() {
		return commits;
	}

	public void setCommits(List<CommitResult> commits) {
		this.commits = commits;
	}
}
