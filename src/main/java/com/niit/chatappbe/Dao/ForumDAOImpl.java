package com.niit.chatappbe.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.chatappbe.model.Blog;
import com.niit.chatappbe.model.Forum;

public class ForumDAOImpl implements ForumDAO{

	@Autowired(required=true)
	SessionFactory sf;

	@Override
	public Forum findById(int forumid) {
		// TODO Auto-generated method stub
		return (Forum) sf.getCurrentSession().get(Forum.class, forumid);
	}

	@Override
	public void saveforum(Forum forum) {
		sf.getCurrentSession().save(forum);

	}

	@Override
	public void updateforum(Forum forum) {
		sf.getCurrentSession().update(forum);

	}

	@Override
	public void deleteforumById(int forum) {
		sf.getCurrentSession().delete(forum);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> findAllForum() {
		// TODO Auto-generated method stub
		return (List<Forum>) sf.getCurrentSession().createQuery("from Forum").list();
	}

	@Override
	public void deleteAllForum() {
		sf.getCurrentSession().delete(findAllForum());

	}

	@Override
	public Forum findByName(String forumname) {
		// TODO Auto-generated method stub
		return (Forum) sf.getCurrentSession().get(Forum.class, forumname);
	}

	
}
