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

import com.bujair.model.CashInfo;
import com.bujair.service.CashService;
import com.bujair.vo.BaseVo;

/**
 * @author Bujair
 *
 */
@RestController
public class CashController extends MyAPIController{
	
	@Autowired
	CashService cashService;
	
	@GetMapping("/cash")
	/**
	 * Getting all the Users 
	 * @return
	 */
	public BaseVo getCash(){
		logger.debug("GET Cashs");
		List<CashInfo> data=cashService.getCash();
		return prepareResponse(data);
	}
	
	/**
	 * Getting User data based on ID  
	 * @param id
	 * @return
	 */
	@GetMapping(path="/cash/{id}")
	public BaseVo getCash(@PathVariable("id") String id) {
		CashInfo data=cashService.getCash(Long.parseLong(id));
		return prepareResponse(data);
	}
	
	/**
	 * Deleting cash 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path="/cash/{id}")
	public BaseVo deleteCash(@PathVariable("id") String id) {
		cashService.deleteCash(Long.parseLong(id)); 
		return prepareResponse();
	}
	
	/**
	 * Creating or Updating the User
	 * 
	 * @param cash
	 * @return
	 */
	@PostMapping("/cash")
    public BaseVo saveCash(@Valid @RequestBody CashInfo cash) {
		logger.debug("Cash is -->",cash);
		CashInfo data=cashService.save(cash);
		return prepareResponse(data);
    }

}
