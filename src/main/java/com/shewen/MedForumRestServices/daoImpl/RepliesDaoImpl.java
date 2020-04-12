package com.shewen.MedForumRestServices.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.shewen.MedForumRestServices.dao.RepliesDao;
import com.shewen.MedForumRestServices.dto.Replies;
import com.shewen.MedForumRestServices.dto.RepliesResponse;


@Service
public class RepliesDaoImpl implements RepliesDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public RepliesDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	public RepliesResponse addReplies(int topic_id, String author, String comment) {
			
		RepliesResponse response = new RepliesResponse();
		
		try {
			String sql = "INSERT INTO she_replies(topic_id, author, comment, date_posted) VALUES(?, ?, ?, now())";
			int retVal = jdbcTemplate.update(sql, topic_id, author, comment);
			
			if(retVal > 0) {
				response.setResponsecode("00");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			response.setResponsecode("O1");
		}
		return response;
	}

	public List<Replies> getAllRepliesByTopicId(int topic_id) {
		try {
			String sql = "SELECT replies_id, topic_id, author, comment, date_posted FROM she_replies WHERE topic_id=" + topic_id;
			List<Replies> retVal = jdbcTemplate.query(sql, new RepliesMapper());
			if(retVal.size() > 0) {
				return retVal;
			}
			else {
				retVal = new ArrayList<Replies>();
				return retVal; 
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public class RepliesMapper implements RowMapper<Replies> {
		public Replies mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Replies replies = new Replies();
			replies.setReplies_id(rs.getInt("replies_id"));
			replies.setTopic_id(rs.getInt("topic_id"));
			replies.setAuthor(rs.getString("author"));
			replies.setComment(rs.getString("comment"));
			replies.setDate(rs.getString("date_posted"));
			
			return replies;
		}
	}

}
