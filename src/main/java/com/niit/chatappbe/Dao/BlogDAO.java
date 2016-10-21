package com.niit.chatappbe.Dao;

import java.util.List;

import com.niit.chatappbe.model.Blog;

public interface BlogDAO {

	public Blog findById(int blogid);
	public Blog findByName(String blogname);
	public void saveblog(Blog blog);
	public void updateblog(Blog blog);
	public void deleteblogById(int blog);
	public List<Blog> findAllBlog();
	public void deleteAllBlog();
	public boolean isBlogExist(String blog);
	
}
