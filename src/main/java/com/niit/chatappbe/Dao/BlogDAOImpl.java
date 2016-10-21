package com.niit.chatappbe.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.chatappbe.model.Blog;

@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired(required=true)
	SessionFactory sf;

	@Override
	public Blog findById(int blogid) {
		// TODO Auto-generated method stub
		return (Blog) sf.getCurrentSession().get(Blog.class, blogid);
	}

	@Override
	public void saveblog(Blog blog) {
		sf.getCurrentSession().save(blog);

	}

	@Override
	public void updateblog(Blog blog) {
		sf.getCurrentSession().update(blog);

	}

	@Override
	public void deleteblogById(int blog) {
		sf.getCurrentSession().delete(blog);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findAllBlog() {
		// TODO Auto-generated method stub
		return (List<Blog>) sf.getCurrentSession().createQuery("from Blog").list();
	}

	@Override
	public void deleteAllBlog() {
		sf.getCurrentSession().delete(findAllBlog());

	}

	@Override
	public Blog findByName(String blogname) {
		// TODO Auto-generated method stub
		return (Blog) sf.getCurrentSession().get(Blog.class, blogname);
	}

	@Override
	public boolean isBlogExist(String blogname) {
		boolean isBlogExist=false;
		Query q=sf.getCurrentSession().createQuery("from Blog where blogname='"+blogname+"'");
		List<Blog> blog = q.list();
		int size=blog.size();
		if (size==1)
				
				{
			isBlogExist=true;
				}
		return isBlogExist;
	}

}
