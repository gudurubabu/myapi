/**
 * 
 */
package com.bujair.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bujair.service.UserService;
import com.bujair.vo.BaseVo;
import com.bujair.vo.UserVo;

/**
 * @author bujair
 *
 */
@RestController
public class MyAPIController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getUsers")
	public BaseVo getUsers(){
		return userService.getUser();
	}

	@GetMapping(path="/getUser/{id}")
	public BaseVo getProduct(@PathVariable("id") String id) {
		return userService.getUser(Long.parseLong(id));
	}
	
	@PostMapping("/user")
    public UserVo createNote(@Valid @RequestBody UserVo user) {
        return userService.save(user);
    }
}
