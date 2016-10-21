package com.niit.chatappbe.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Blog {

	@Id
	private int blogid;
	private String blogname;
	private Time posttime;
	private Date postdate;
	private boolean blogapproval;
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public Time getPosttime() {
		return posttime;
	}
	public void setPosttime(Time posttime) {
		this.posttime = posttime;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public boolean isBlogapproval() {
		return blogapproval;
	}
	public void setBlogapproval(boolean blogapproval) {
		this.blogapproval = blogapproval;
	}

	
}
