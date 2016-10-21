package com.niit.chatappbe.Dao;

import java.util.List;

import com.niit.chatappbe.model.UserDetails;

public interface UserDAO {

public UserDetails findById(int userid);
	
	public UserDetails findByName(String username);
	
	public	void saveUser(UserDetails userdetails);
	
	public void updateUser(UserDetails userdetails);
	
	public void deleteUserById(int userid);

	public List<UserDetails> findAllUsers(); 
	
	public void deleteAllUsers();
	
	public boolean isUserExist(String email);
	
}
