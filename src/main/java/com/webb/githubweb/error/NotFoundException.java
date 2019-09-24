package com.webb.githubweb.error;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4457368314994802975L;
	public NotFoundException(Long id) {
		   super("Object id not found : " + id);
	}
}
