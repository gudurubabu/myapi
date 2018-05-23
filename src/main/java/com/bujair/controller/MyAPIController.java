/**
 * 
 */
package com.bujair.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bujair.vo.BaseVo;

/**
 * @author bujair
 *
 */
@RestController
public class MyAPIController {
	
	@RequestMapping("/getUsers")
	public BaseVo getUsers() {
		return null;
	}

	@RequestMapping("/getUser")
	public BaseVo getProduct(@RequestParam(value = "userID", required = true) String userID) {
		return null;
	}
}
