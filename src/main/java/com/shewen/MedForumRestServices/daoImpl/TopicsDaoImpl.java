package com.shewen.MedForumRestServices.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.shewen.MedForumRestServices.dao.TopicsDao;
import com.shewen.MedForumRestServices.dto.Categories;
import com.shewen.MedForumRestServices.dto.Topics;
import com.shewen.MedForumRestServices.dto.TopicsResponse;


@Service
public class TopicsDaoImpl implements TopicsDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public TopicsDaoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	public TopicsResponse addTopic(int category_id, int subcategory_id, String author, String title, String content) {
		
		TopicsResponse response = new TopicsResponse();
		
		try {
			
			String sql = "INSERT INTO she_topics (category_id, subcategory_id, author, title, content, date_posted) VALUES(?, ?, ?, ?, ?, now())";
			int retVal = jdbcTemplate.update(sql, category_id, subcategory_id, author, title, content);
			
			response.setResponsecode("00");
		}
		catch (Exception e) {
			e.printStackTrace();
			response.setResponsecode("01");
		}
		
		return response;
	}

	public List<Topics> getAllTopicsTitle() {
		try {
			String sql = "SELECT a.topic_id, a.title, a.author, a.date_posted, COUNT(b.comment) AS topic_comments FROM she_topics a LEFT JOIN she_replies b ON a.topic_id = b.topic_id GROUP BY topic_id ORDER BY date_posted DESC";
			List<Topics> retVal = jdbcTemplate.query(sql, new TopicsMapper());
			if(retVal.size() > 0) {
				return retVal;
			}
			else {
				retVal = new ArrayList<Topics>();
				return retVal;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public class TopicsMapper implements RowMapper<Topics> {

		public Topics mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Topics topic = new Topics();

			topic.setTopic_id(rs.getInt("topic_id"));
			topic.setTitle(rs.getString("title"));
			topic.setAuthor(rs.getString("author"));
			topic.setDate(rs.getString("date_posted").substring(0, 10));
			topic.setTopic_comments(rs.getInt("topic_comments"));
			
			return topic;
		}
	}

	public Topics getTopicById(int topicId) {
		String sql = "SELECT topic_id, author, title, content, date_posted FROM she_topics WHERE topic_id='"+ topicId +"'";
		
		return jdbcTemplate.query(sql, new ResultSetExtractor<Topics>() {

			public Topics extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Topics topics = new Topics();
					topics.setTopic_id(rs.getInt("topic_id"));
					topics.setAuthor(rs.getString("author"));
					topics.setTitle(rs.getString("title"));
					topics.setContent(rs.getString("content"));
					topics.setDate(rs.getString("date_posted"));
					
					return topics;
				}
				return null;
			}
			
		});		
		
	}

	public List<Topics> getTopicsByCategory(int category_id) {
		try {
			String sql = "SELECT topic_id, title FROM she_topics WHERE category_id=" + category_id;
			List<Topics> retVal = jdbcTemplate.query(sql, new TopicsMapper());
			if(retVal.size() > 0) {
				return retVal;
			}
			else {
				retVal = new ArrayList<Topics>();
				return retVal;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Topics> getTopicsBySubCategory(int subcategory_id) {
		try {
			String sql = "SELECT a.topic_id, a.title, a.author, a.date_posted, COUNT(b.comment) AS topic_comments FROM she_topics a LEFT JOIN she_replies b ON a.topic_id = b.topic_id where a.subcategory_id = "+subcategory_id+" GROUP BY topic_id ORDER BY date_posted DESC";
			List<Topics> retVal = jdbcTemplate.query(sql, new TopicsMapper());
			if(retVal.size() > 0) {
				return retVal;
			}
			else {
				retVal = new ArrayList<Topics>();
				return retVal;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
