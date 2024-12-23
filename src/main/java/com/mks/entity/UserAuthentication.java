package com.mks.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserAuthentication {

	@NotNull
	@Size(min=8, max=30)
	private String username;
	@NotNull
	@Size(min=8, max=255)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
