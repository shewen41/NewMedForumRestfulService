package com.shewen.MedForumRestServices.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.shewen.MedForumRestServices.dao.UsersDao;
import com.shewen.MedForumRestServices.dto.LoginResponse;
import com.shewen.MedForumRestServices.dto.Users;
import com.shewen.MedForumRestServices.dto.UsersResponse;


@Service
public class UsersDaoImpl implements UsersDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public UsersDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public UsersResponse addUser(String username, String role, boolean enabled, String password, String email) {
		
			UsersResponse response = new UsersResponse();
		
		try {
			
			String emailCheck = "SELECT COUNT(email) FROM user_details WHERE email=?";
			
			String usernameCheck = "SELECT COUNT(username) FROM user_details WHERE username=?";
			
			int retValForEmail = jdbcTemplate.queryForObject(emailCheck, new Object[]{email}, Integer.class);
			 
			int retValForUsername = jdbcTemplate.queryForObject(usernameCheck, new Object[]{username}, Integer.class);
			
			if(retValForEmail > 0) {
				
				response.setResponsecode("03");
				
				return response;
			}
			else if(retValForUsername > 0) {
				
				response.setResponsecode("02");
				
				return response;
			}
			else {
				String sql = "INSERT INTO user_details (username, role, enabled, password, email, date) VALUES(?, ?, ?, ?, ?, now())";
				
				jdbcTemplate.update(sql, username, role, enabled, password, email);
				
				response.setResponsecode("00");
				
				return response;
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
			response.setResponsecode("01");
			return response;
		}
		
	}

	public LoginResponse userLogin(String username) {
		
		LoginResponse response = new LoginResponse();
		
		String sql = "SELECT COUNT(username) FROM user_details WHERE username=?";
		
		int retVal = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
		
		if(retVal == 1) {
			String token = alphaNumericString(15);
			
			sql = "UPDATE user_details set token = ? WHERE username='"+ username +"'";
			
			jdbcTemplate.update(sql, token);
			
			//System.out.println(token);
			
			response.setToken(token);
			response.setResponsecode("00");
			
			return response;
		}
		else {
			response.setResponsecode("01");
			
			return response;
		}
	}

	public LoginResponse userLoginP(String token, String password) {
		
		String t = alphaNumericString(15);
	
		LoginResponse response = new LoginResponse();
		
		String newtoks = null;
		
		try {
			String sql = "";
			
			int ret = 0;
			
			sql = "SELECT COUNT(*) FROM user_details WHERE password=? AND token=?";
			
			int retVal = jdbcTemplate.queryForObject(sql, new Object[] {password, token}, Integer.class);
			
			if(retVal > 0) {
				
				newtoks = alphaNumericString(15);
				
				sql = "UPDATE user_details SET token= ? WHERE password='"+ password +"' AND token='"+ token +"'";
				
				ret = jdbcTemplate.update(sql, newtoks);
			}
			
			if(ret > 0) {
				sql = "SELECT user_id, role, username, token FROM user_details WHERE password=? AND token=?";
				
				LoginResponse profile = jdbcTemplate.queryForObject(sql, new Object[] {password, newtoks}, new ProfileMapper());
				
				return profile;
			}
			else {
				response.setResponsecode("02");
				
				return response;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setResponsecode("01");
			
			return response;
		}
	}
	
	class ProfileMapper implements RowMapper<LoginResponse> {

		public LoginResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			LoginResponse response = new LoginResponse();
			
			response.setResponsecode("00");
			response.setUser_id(rs.getInt("user_id"));
			response.setUsername(rs.getString("username"));
			response.setRole(rs.getString("role"));
			response.setToken(rs.getString("token"));
			
			return response;
		}
	}
	
	public String alphaNumericString(int n) {
		
		String AlphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		StringBuilder sb = new StringBuilder(n);
		
		for(int i = 0; i < n; i++) {
			int index = (int)(AlphaNumeric.length() * Math.random());
			
			sb.append(AlphaNumeric.charAt(index));
		}
		return sb.toString();
	}

}
