package com.webb.githubweb.model;

import java.io.Serializable;
import java.util.Date;

public class Repo implements Serializable {
	private static final long serialVersionUID = 1139632695582541767L;
	
	private String name;
	private String full_name;
	private String description;
	private String html_url;
	private String language;
	private int stargazers_count;
	private int total_count  ;
	private Date updated_at;
	private License license;
	
	private String developer_commits;
	
	private String timeline_commits;
	
	private String commits_details;
	
	public String getDeveloper_commits() {
		developer_commits=CommitLinks.DEVELOPER_COMMITS+full_name;
		return developer_commits;
	}
	public void setDeveloper_commits(String developer_commits) {
		this.developer_commits = developer_commits;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getStargazers_count() {
		return stargazers_count;
	}
	public void setStargazers_count(int stargazers_count) {
		this.stargazers_count = stargazers_count;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public License getLicense() {
		return license;
	}
	public void setLicense(License license) {
		this.license = license;
	}
	public String getTimeline_commits() {
		timeline_commits =CommitLinks.TIMELINE_COMMITS+full_name;
		return timeline_commits;
	}
	public void setTimeline_commits(String timeline_commits) {
		this.timeline_commits = timeline_commits;
	}
	public String getCommits_details() {
		commits_details=CommitLinks.DETAILS_COMMITS+full_name;
		return commits_details;
	}
	public void setCommits_details(String commits_details) {
		this.commits_details = commits_details;
	}

}
