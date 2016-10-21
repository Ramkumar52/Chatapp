package com.niit.chatappbe.Service;

import java.util.List;

import com.niit.chatappbe.model.Blog;
import com.niit.chatappbe.model.UserDetails;

public interface BlogService {

	public Blog findById(int blogid);
	public Blog findByName(String blogname);
	public void saveblog(Blog blog);
	public void updateblog(Blog blog);
	public void deleteblogById(int blogid);
	public List<Blog> findAllBlog();
	public void deleteAllBlog();
	public boolean isBlogExist(String blog);
	
}
