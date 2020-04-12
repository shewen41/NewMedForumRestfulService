package com.shewen.MedForumRestServices.dao;

import com.shewen.MedForumRestServices.dto.LoginResponse;
import com.shewen.MedForumRestServices.dto.Users;
import com.shewen.MedForumRestServices.dto.UsersResponse;

public interface UsersDao {
	
	public UsersResponse addUser(String username, String role, boolean enabled, String password, String email);
	
	public LoginResponse userLogin(String username);
	
	public LoginResponse userLoginP(String token, String password);

}
