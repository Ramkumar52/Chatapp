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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.chatappbe.Service.BlogService;
import com.niit.chatappbe.Service.UserService;
import com.niit.chatappbe.model.Blog;
import com.niit.chatappbe.model.UserDetails;

@RestController
public class UserController {

	 @Autowired
	    UserService userService;  //Service which will do all data retrieval/manipulation work
	 
	    
	    //-------------------Retrieve All Users--------------------------------------------------------
	     
	    @RequestMapping(value = "/user/", method = RequestMethod.GET)
	    public ResponseEntity<List<UserDetails>> listAllUsers() {
	        List<UserDetails> users = userService.findAllUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<UserDetails>>(users, HttpStatus.OK);
	    }
	 
	 
	    
	    //-------------------Retrieve Single User--------------------------------------------------------
	     
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<UserDetails> getUser(@PathVariable("userid") int userid) {
	        System.out.println("Fetching User with id " + userid);
	        UserDetails user = userService.findById(userid);
	        if (user == null) {
	            System.out.println("User with id " + userid + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	    }
	 
	     
	     
	    //-------------------Create a User--------------------------------------------------------
	     
	    @RequestMapping(value = "/user/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createUser(@RequestBody UserDetails user,    UriComponentsBuilder ucBuilder) {
	        System.out.println("Creating User " + user.getUsername());
	 
	        if (userService.isUserExist(user.getEmail())) {
	            System.out.println("A User with name " + user.getUsername() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	 
	        userService.saveUser(user);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/user/{userid}").buildAndExpand(user.getUserid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	    
	     
	    //------------------- Update a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
	    public ResponseEntity<UserDetails> updateUser(@PathVariable("userid") int userid, @RequestBody UserDetails user) {
	        System.out.println("Updating User " + userid);
	         
	        UserDetails currentUser = userService.findById(userid);
	         
	        if (currentUser==null) {
	            System.out.println("User with id " + userid + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	 
	        currentUser.setUsername(user.getUsername());
	        currentUser.setMobileno(user.getMobileno());
	        currentUser.setEmail(user.getEmail());
	         
	        userService.updateUser(currentUser);
	        return new ResponseEntity<UserDetails>(currentUser, HttpStatus.OK);
	    }
	 
	    
	    
	    //------------------- Delete a User --------------------------------------------------------
	     
	    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<UserDetails> deleteUser(@PathVariable("UserDetails") int userid) {
	        System.out.println("Fetching & Deleting User with userid " + userid);
	 
	        UserDetails user = userService.findById(userid);
	        if (user == null) {
	            System.out.println("Unable to delete. User with id " + userid + " not found");
	            return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
	        }
	 
	        userService.deleteUserById(userid);
	        return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
	    }
	 
	     
	    
	    //------------------- Delete All Users --------------------------------------------------------
	     
	    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
	    public ResponseEntity<UserDetails> deleteAllUsers() {
	        System.out.println("Deleting All Users");
	 
	        userService.deleteAllUsers();
	        return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
	    }
}
