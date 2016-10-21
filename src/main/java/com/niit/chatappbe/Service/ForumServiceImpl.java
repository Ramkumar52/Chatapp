package com.niit.chatappbe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.chatappbe.Dao.ForumDAO;
import com.niit.chatappbe.model.Forum;

public class ForumServiceImpl implements ForumService {

	
	@Autowired
	ForumDAO forumDao;
	@Override
	public Forum findById(int forumid) {
		// TODO Auto-generated method stub
		return forumDao.findById(forumid);
	}

	@Override
	public Forum findByName(String forumname) {
		// TODO Auto-generated method stub
		return forumDao.findByName(forumname);
	}

	@Override
	public void saveforum(Forum forum) {
		// TODO Auto-generated method stub
		forumDao.saveforum(forum);
	}

	@Override
	public void updateforum(Forum forum) {
		// TODO Auto-generated method stub
		forumDao.updateforum(forum);
	}

	@Override
	public void deleteforumById(int forumid) {
		// TODO Auto-generated method stub
		forumDao.deleteforumById(forumid);
	}

	@Override
	public List<Forum> findAllForum() {
		// TODO Auto-generated method stub
		return forumDao.findAllForum();
	}

	@Override
	public void deleteAllForum() {
		// TODO Auto-generated method stub
		forumDao.deleteAllForum();
	}

}
