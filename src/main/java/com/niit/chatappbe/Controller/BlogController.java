package com.niit.chatappbe.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.chatappbe.Service.BlogService;
import com.niit.chatappbe.model.Blog;

@RestController
public class BlogController {

	 @Autowired
	 BlogService blogservice;  //Service which will do all data retrieval/manipulation work
	 
	    
	    //-------------------Retrieve All Blog--------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/", method = RequestMethod.GET)
	    public ResponseEntity<List<Blog>> listAllBlog() {
	        List<Blog> blog = blogservice.findAllBlog();
	        if(blog.isEmpty()){
	            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single Blog--------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/{blogid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Blog> getUser(@PathVariable("blogid") int blogid) {
	        System.out.println("Fetching Blog with id " + blogid);
	        Blog blog = blogservice.findById(blogid);
	        if (blog == null) {
	            System.out.println("Blog with id " + blogid + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a Blog--------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/", method = RequestMethod.POST)
	    public ResponseEntity<Void> saveblog(@RequestBody Blog blog,    UriComponentsBuilder ucBuilder) {
	 
	        if (blogservice.isBlogExist(blog.getBlogname())) {
	            System.out.println("A User with name " + blog.getBlogid() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        blogservice.saveblog(blog);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/blog/{blogid}").buildAndExpand(blog.getBlogid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a Blog --------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/{blogid}", method = RequestMethod.PUT)
	    public ResponseEntity<Blog> updateUser(@PathVariable("blogid") int blogid, @RequestBody Blog blog) {
	        System.out.println("Updating Blog " + blogid);
	         
	        Blog currentblog = blogservice.findById(blogid);
	         
	        if (currentblog==null) {
	            System.out.println("Blog with id " + blogid + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentblog.setBlogname(blog.getBlogname());
	        currentblog.setPosttime(blog.getPosttime());
	        currentblog.setPostdate(blog.getPostdate());
	         
	        blogservice.updateblog(currentblog);
	        return new ResponseEntity<Blog>(currentblog, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a Blog --------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/{blogid}", method = RequestMethod.DELETE)
	    public ResponseEntity<Blog> deleteUser(@PathVariable("blogid") int blogid) {
	        System.out.println("Fetching & Deleting Blog with id " + blogid);
	 
	        Blog blog = blogservice.findById(blogid);
	        if (blog == null) {
	            System.out.println("Unable to delete. Blog with id " + blogid + " not found");
	            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
	        }
	 
	        blogservice.deleteblogById(blogid);
	        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Blog --------------------------------------------------------
	     
	    @RequestMapping(value = "/blog/", method = RequestMethod.DELETE)
	    public ResponseEntity<Blog> deleteAllBlog() {
	        System.out.println("Deleting All Blog");
	 
	        blogservice.deleteAllBlog();
	        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
	    }
	
}
