package com.niit.chatappbe.Dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.chatappbe.model.Blog;
import com.niit.chatappbe.model.UserDetails;

public class UserDaoImpl implements UserDAO {

	@Autowired(required=true)
	SessionFactory sf;
	
	@Override
	public UserDetails findById(int userid) {
		// TODO Auto-generated method stub
		return (UserDetails) sf.getCurrentSession().get(UserDetails.class, userid);
	}

	@Override
	public UserDetails findByName(String username) {
		// TODO Auto-generated method stub
		return (UserDetails) sf.getCurrentSession().get(UserDetails.class, username);
	}

	@Override
	public void saveUser(UserDetails userdetails) {
		sf.getCurrentSession().save(userdetails);

	}

	@Override
	public void updateUser(UserDetails userdetails) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(userdetails);
	}

	@Override
	public void deleteUserById(int userid) {
		sf.getCurrentSession().delete(userid);

	}

	@Override
	public List<UserDetails> findAllUsers() {
		// TODO Auto-generated method stub
 return (List<UserDetails>) sf.getCurrentSession().createQuery("from UserDetails").list();
	}

	@Override
	public void deleteAllUsers() {
		sf.getCurrentSession().delete(findAllUsers());

	}

	@Override
	public boolean isUserExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
