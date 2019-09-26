package com.webb.githubweb.model;

public interface CommitLinks {
	String DEVELOPER_COMMITS="/commits?chart=developer&full_name=";
	String TIMELINE_COMMITS="/commits?chart=timeline&full_name=";
	String DETAILS_COMMITS="/commits?chart=-1&full_name=";
	String COMMITERS_LINK="/users?full_name=";
}
