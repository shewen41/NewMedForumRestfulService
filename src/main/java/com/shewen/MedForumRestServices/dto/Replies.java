package com.shewen.MedForumRestServices.dto;

public class Replies {

	private int replies_id;
	
	private int topic_id;
	
	private String author;
	
	private String comment;
	
	private String date;

	public int getReplies_id() {
		return replies_id;
	}

	public void setReplies_id(int replies_id) {
		this.replies_id = replies_id;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Replies [replies_id=" + replies_id + ", topic_id=" + topic_id + ", author=" + author + ", comment="
				+ comment + ", date=" + date + "]";
	}
	
	
	
}
