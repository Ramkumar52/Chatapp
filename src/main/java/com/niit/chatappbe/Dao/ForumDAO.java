package com.niit.chatappbe.Dao;

import java.util.List;

import com.niit.chatappbe.model.Forum;

public interface ForumDAO {

	public Forum findById(int forumid);
	public Forum findByName(String forumname);
	public void saveforum(Forum forum);
	public void updateforum(Forum forum);
	public void deleteforumById(int forumid);
	public List<Forum> findAllForum();
	public void deleteAllForum();
	
}
