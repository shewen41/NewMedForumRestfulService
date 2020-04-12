package com.shewen.MedForumRestServices.dto;

import java.util.Date;

public class Topics {

	private int topic_id;
	
	private int category_id;
	
	private int subcategory_id;
	
	private String author;
	
	private String title;
	
	private String content;
	
	private int views;
	
	private String date;
	
	private int topic_comments;

	
	
	public int getTopic_comments() {
		return topic_comments;
	}

	public void setTopic_comments(int topic_comments) {
		this.topic_comments = topic_comments;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getSubcategory_id() {
		return subcategory_id;
	}

	public void setSubcategory_id(int subcategory_id) {
		this.subcategory_id = subcategory_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Topics [topic_id=" + topic_id + ", category_id=" + category_id + ", subcategory_id=" + subcategory_id
				+ ", author=" + author + ", title=" + title + ", content=" + content + ", views=" + views + ", date="
				+ date + ", topic_comments=" + topic_comments + "]";
	}
	
	
	
	
}
