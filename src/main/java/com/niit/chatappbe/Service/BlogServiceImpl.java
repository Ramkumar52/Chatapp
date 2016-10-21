package com.niit.chatappbe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatappbe.Dao.BlogDAO;
import com.niit.chatappbe.model.Blog;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired(required=true)
	BlogDAO blogDao;
	
	@Override
	public Blog findById(int blogid) {
		
		return blogDao.findById(blogid);
	}

	@Override
	public void saveblog(Blog blog) {
		blogDao.saveblog(blog);

	}

	@Override
	public void updateblog(Blog blog) {
		blogDao.updateblog(blog);

	}

	@Override
	public void deleteblogById(int blog) {
		blogDao.deleteblogById(blog);

	}

	@Override
	public List<Blog> findAllBlog() {
		// TODO Auto-generated method stub
		return blogDao.findAllBlog();
	}

	@Override
	public void deleteAllBlog() {
		blogDao.deleteAllBlog();

	}

	@Override
	public Blog findByName(String blogname) {
		return blogDao.findByName(blogname);
	}

	@Override
	public boolean isBlogExist(String blog) {
		boolean isBlogExist=false;
		isBlogExist=blogDao.isBlogExist(blog);
		if(isBlogExist==true){
			isBlogExist=true;
		}
		return isBlogExist;
	}

	
}
