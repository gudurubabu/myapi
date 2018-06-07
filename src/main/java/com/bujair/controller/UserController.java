/**
 * 
 */
package com.bujair.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bujair.model.UserInfo;
import com.bujair.service.UserService;
import com.bujair.vo.BaseVo;

/**
 * @author Bujair
 *
 */
@RestController
public class UserController extends MyAPIController{
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	/**
	 * Getting all the Users 
	 * @return
	 */
	public BaseVo getUser(){
		logger.debug("GET USERS");
		List<UserInfo> data=userService.getUser();
		return prepareResponse(data);
	}
	
	/**
	 * Getting User data based on ID  
	 * @param id
	 * @return
	 */
	@GetMapping(path="/user/{id}")
	public BaseVo getUser(@PathVariable("id") String id) {
		UserInfo data=userService.getUser(Long.parseLong(id));
		return prepareResponse(data);
	}
	
	/**
	 * Deleting user 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path="/user/{id}")
	public BaseVo deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(Long.parseLong(id)); 
		return prepareResponse();
	}
	
	/**
	 * Creating or Updating the User
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/user")
    public BaseVo createNote(@Valid @RequestBody UserInfo user) {
		UserInfo data=userService.save(user);
		return prepareResponse(data);
    }

}
