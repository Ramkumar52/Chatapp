package com.niit.chatappbe.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Forum {

	@Id
	private int forumid;
	private String forumname;
	private Date postdate;
	private Time posttime;
	private int commentid;
	private boolean forumapproval;
	private int rating;
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public Time getPosttime() {
		return posttime;
	}
	public void setPosttime(Time posttime) {
		this.posttime = posttime;
	}
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public boolean isForumapproval() {
		return forumapproval;
	}
	public void setForumapproval(boolean forumapproval) {
		this.forumapproval = forumapproval;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
}
