package com.niit.chatappbe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.chatappbe.Dao.BlogDAO;
import com.niit.chatappbe.Dao.UserDAO;
import com.niit.chatappbe.model.Blog;
import com.niit.chatappbe.model.UserDetails;

public class UserServiceImpl implements UserService {


	@Autowired(required=true)
	UserDAO userdao;
	
	@Override
	public UserDetails findById(int userid) {
		
		return userdao.findById(userid);
	}

	@Override
	public void saveUser(UserDetails userdetails) {
		userdao.saveUser(userdetails);

	}

	@Override
	public void updateUser(UserDetails userdetails) {
		userdao.updateUser(userdetails);

	}

	@Override
	public void deleteUserById(int userid) {
		userdao.deleteUserById(userid);

	}

	@Override
	public List<UserDetails> findAllUsers() {
		// TODO Auto-generated method stub
		return userdao.findAllUsers();
	}

	@Override
	public void deleteAllUsers() {
		userdao.deleteAllUsers();

	}

	@Override
	public UserDetails findByName(String username) {
		return userdao.findByName(username);
	}

	@Override
	public boolean isUserExist(String email) {
		boolean isUserExist=false;
		isUserExist=userdao.isUserExist(email);
		if(isUserExist==true){
			isUserExist=true;
		}
		return isUserExist;
	}
}
