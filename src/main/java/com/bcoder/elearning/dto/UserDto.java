package com.bcoder.elearning.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {

	private int id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;

	public UserDto() {
	}
	public UserDto(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
