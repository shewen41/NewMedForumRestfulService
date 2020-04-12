package com.shewen.MedForumRestServices.dao;

import java.util.List;

import com.shewen.MedForumRestServices.dto.Topics;
import com.shewen.MedForumRestServices.dto.TopicsResponse;

public interface TopicsDao {
	
	public TopicsResponse addTopic(int category_id, int subcategory_id, String author, String title, String content);
	
	public List<Topics> getAllTopicsTitle();
	
	public Topics getTopicById(int topicId);
	
	public List<Topics> getTopicsByCategory(int category_id);
	
	public List<Topics> getTopicsBySubCategory(int subcategory_id);

}
