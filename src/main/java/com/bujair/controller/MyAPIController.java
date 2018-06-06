/**
 * 
 */
package com.bujair.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bujair.model.UserInfo;
import com.bujair.service.UserService;
import com.bujair.vo.BaseVo;

/**
 * @author Bujair
 *
 */
@RestController
@RequestMapping("/api")
public class MyAPIController {
	
	private static final String SUCCESS = "SUCCESS";

	Logger logger = LoggerFactory.getLogger(MyAPIController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/getUsers")
	public BaseVo getUsers(){
		logger.debug("GET USERS");
		List<UserInfo> data=userService.getUser();
		return prepareResponse(data);
	}

	private BaseVo prepareResponse(Object data) {
		BaseVo output =prepareResponse();
		output.setData(data);
		return output;
	}

	private BaseVo prepareResponse() {
		BaseVo output =new BaseVo();
		output.setMessage(SUCCESS);
		return output;
	}

	@GetMapping(path="/getUser/{id}")
	public BaseVo getProduct(@PathVariable("id") String id) {
		UserInfo data=userService.getUser(Long.parseLong(id));
		return prepareResponse(data);
	}
	
	@DeleteMapping(path="/getUser/{id}")
	public BaseVo deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(Long.parseLong(id)); 
		return prepareResponse();
	}
	
	@PostMapping("/user")
    public BaseVo createNote(@Valid @RequestBody UserInfo user) {
		UserInfo data=userService.save(user);
		return prepareResponse(data);
    }
}
