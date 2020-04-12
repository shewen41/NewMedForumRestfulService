package com.shewen.MedForumRestServices.dao;

import java.util.List;

import com.shewen.MedForumRestServices.dto.Replies;
import com.shewen.MedForumRestServices.dto.RepliesResponse;

public interface RepliesDao {
	
	public RepliesResponse addReplies(int topic_id, String author, String comment);
	
	public List<Replies> getAllRepliesByTopicId(int topic_id);

}
