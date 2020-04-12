package com.shewen.MedForumRestServices.dto;

public class Users {
	
	
	private int user_id;
	
	private String username;
	
	private String role;
	
	private boolean enabled;
	
	private String password;
	
	private String email;
	
	private String token;
	
	private String date_created;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", role=" + role + ", enabled=" + enabled
				+ ", password=" + password + ", email=" + email + ", token=" + token + ", date_created=" + date_created
				+ "]";
	}
	
	
	
	

}
