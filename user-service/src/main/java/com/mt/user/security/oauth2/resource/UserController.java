package com.mt.user.security.oauth2.resource;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.user.security.oauth2.model.security.User;
import com.mt.user.security.oauth2.service.UserDetailsServiceImpl;
 

@RestController
@RequestMapping("/secured")
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:1111"},maxAge = 4800) 
public class UserController {

	@Autowired
	UserDetailsServiceImpl userService;
	
	@RequestMapping(path="/user/create", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public User createUser(@RequestBody User userTo) {
		
		return userService.saveUser(userTo);
	}
	
	@RequestMapping(path="/user/get/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}
	
	
	@RequestMapping(path="/userInfo",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Principal userInfo(Principal principal){
		userService.loadUserByUsername(principal.getName());
        return principal;
    }
	
	

	
}
