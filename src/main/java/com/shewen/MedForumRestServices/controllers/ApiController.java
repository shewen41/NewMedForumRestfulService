package com.shewen.MedForumRestServices.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shewen.MedForumRestServices.dao.CategoriesDao;
import com.shewen.MedForumRestServices.dao.RepliesDao;
import com.shewen.MedForumRestServices.dao.SubCategoriesDao;
import com.shewen.MedForumRestServices.dao.TopicsDao;
import com.shewen.MedForumRestServices.dao.UsersDao;
import com.shewen.MedForumRestServices.dto.Categories;
import com.shewen.MedForumRestServices.dto.LoginResponse;
import com.shewen.MedForumRestServices.dto.Replies;
import com.shewen.MedForumRestServices.dto.RepliesResponse;
import com.shewen.MedForumRestServices.dto.SubCategories;
import com.shewen.MedForumRestServices.dto.Topics;
import com.shewen.MedForumRestServices.dto.TopicsResponse;
import com.shewen.MedForumRestServices.dto.Users;
import com.shewen.MedForumRestServices.dto.UsersResponse;

@RestController
@RequestMapping(value = {"/json/data"})
public class ApiController {
	
	@Autowired
	CategoriesDao categoriesDao;
	
	@Autowired
	SubCategoriesDao subCategoriesDao;
	
	@Autowired
	TopicsDao topicsDao;
	
	@Autowired
	RepliesDao repliesDao;
	
	@Autowired
	UsersDao usersDao;

	
	@RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
	public ResponseEntity<List<Categories>> getAllCategories(){
		List<Categories> categories = categoriesDao.getAllCategories();
		
		return new ResponseEntity<List<Categories>>(categories, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/subcategories"}, method = RequestMethod.GET)
	public ResponseEntity<List<SubCategories>> getAllSubCategories(){
		List<SubCategories> subcategories = subCategoriesDao.getAllSubCategories();
		
		return new ResponseEntity<List<SubCategories>>(subcategories, HttpStatus.OK);
	}

	@RequestMapping(value = {"/topics"}, method = RequestMethod.POST)
	public ResponseEntity<TopicsResponse> addTopics(@RequestBody Topics topic){
		return new ResponseEntity<TopicsResponse>(topicsDao.addTopic(topic.getCategory_id(), topic.getSubcategory_id(), topic.getAuthor(), topic.getTitle(), topic.getContent()), HttpStatus.OK);
	}

	@RequestMapping(value = {"/topics/titles"}, method = RequestMethod.GET)
	public ResponseEntity<List<Topics>> getAllPostedTopics(){
		List<Topics> topics = topicsDao.getAllTopicsTitle();
	
		return new ResponseEntity<List<Topics>>(topics, HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/topics/category/titles"}, method = RequestMethod.GET)
	public ResponseEntity<List<Topics>> getAllPostedTopicsByCategory(@RequestBody Topics topic){
		List<Topics> topics = topicsDao.getTopicsByCategory(topic.getCategory_id());
	
		return new ResponseEntity<List<Topics>>(topics, HttpStatus.OK);
	}

	@RequestMapping(value = {"/topics/subcategory/titles"}, method = RequestMethod.POST)
	public ResponseEntity<List<Topics>> getAllPostedTopicsBySubCategory(@RequestBody Topics topic){
		List<Topics> topics = topicsDao.getTopicsBySubCategory(topic.getSubcategory_id());
	
		return new ResponseEntity<List<Topics>>(topics, HttpStatus.OK);
	}

	@RequestMapping(value = {"/topicsById"}, method = RequestMethod.POST)
	public ResponseEntity<Topics> getTopicsById(@RequestBody Topics topic){
		
		return new ResponseEntity<Topics>(topicsDao.getTopicById(topic.getTopic_id()), HttpStatus.OK);
	}

	@RequestMapping(value = {"/replies"}, method = RequestMethod.POST)
	public ResponseEntity<RepliesResponse> addReplies(@RequestBody Replies replies){
		return new ResponseEntity<RepliesResponse>(repliesDao.addReplies(replies.getTopic_id(), replies.getAuthor(), replies.getComment()), HttpStatus.OK);
	}
	
	@RequestMapping(value = {"/repliesByTopicId"}, method = RequestMethod.POST)
	public ResponseEntity<List<Replies>> getAllRepliesById(@RequestBody Replies replies){
		List<Replies> reply = repliesDao.getAllRepliesByTopicId(replies.getTopic_id());
		
		return new ResponseEntity<List<Replies>>(reply, HttpStatus.OK); 
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public ResponseEntity<UsersResponse> addUser(@RequestBody Users users){
		return new ResponseEntity<UsersResponse>(usersDao.addUser(users.getUsername(), users.getRole(), true, users.getPassword(), users.getEmail()), HttpStatus.OK);
	}

	
	@RequestMapping(value = {"/login1"}, method = RequestMethod.POST)
	public ResponseEntity<LoginResponse> login(@RequestBody Users users){
		return new ResponseEntity<LoginResponse>(usersDao.userLogin(users.getUsername()), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = {"/login2"}, method = RequestMethod.POST)
	public ResponseEntity<LoginResponse> login2(@RequestBody Users users){
		return new ResponseEntity<LoginResponse>(usersDao.userLoginP(users.getToken(), users.getPassword()), HttpStatus.OK);
	}
		
}
