package com.webb.githubweb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = false)

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommitResult implements Serializable {
	private static final long serialVersionUID = 4115606245138408615L;
	
	private String node_id;
	private String sha;
	
	private String  url;
	private String  html_url;
	private String  comments_url;
	private Author  author;
    private Committer	committer;
	private List<CommitResult> parents;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Commit commit;

	private String authorName;
	private String authorEmail;
	private Date commitDate;
	private String message;
	
	public Commit getCommit() {
		return commit;
	}

	public void setCommit(Commit commit) {
		this.commit = commit;
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getSha() {
		return sha;
	}

	public void setSha(String sha) {
		this.sha = sha;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getComments_url() {
		return comments_url;
	}

	public void setComments_url(String comments_url) {
		this.comments_url = comments_url;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Committer getCommitter() {
		return committer;
	}

	public void setCommitter(Committer committer) {
		this.committer = committer;
	}

	public List<CommitResult> getParents() {
		return parents;
	}

	public void setParents(List<CommitResult> parents) {
		this.parents = parents;
	}

	public String getAuthorName() {
		authorName=commit.getAuthor().getName();
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getCommitDate() {
		commitDate=commit.getAuthor().getDate();
		return commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	public String getAuthorEmail() {
		authorEmail=commit.getAuthor().getEmail();
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	public String getMessage() {
		message=commit.getMessage();
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
