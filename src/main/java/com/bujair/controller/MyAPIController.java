/**
 * 
 */
package com.bujair.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	/**
	 * Preparing the Base data 
	 * @param data
	 * @return
	 */
	public BaseVo prepareResponse(Object data) {
		BaseVo output =prepareResponse();
		output.setData(data);
		return output;
	}

	/**
	 * Creating baseVo data 
	 * @return
	 */
	public BaseVo prepareResponse() {
		BaseVo output =new BaseVo();
		output.setMessage(SUCCESS);
		return output;
	}
	
}
