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

import com.bujair.model.TransactionInfo;
import com.bujair.service.TransactionService;
import com.bujair.vo.BaseVo;

/**
 * @author Bujair
 *
 */
@RestController
public class TransactionController extends MyAPIController{
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transaction")
	/**
	 * Getting all the Users 
	 * @return
	 */
	public BaseVo getTransaction(){
		logger.debug("GET USERS");
		List<TransactionInfo> data=transactionService.getTransaction();
		return prepareResponse(data);
	}
	
	/**
	 * Getting User data based on ID  
	 * @param id
	 * @return
	 */
	@GetMapping(path="/transaction/{id}")
	public BaseVo getTransaction(@PathVariable("id") String id) {
		TransactionInfo data=transactionService.getTransaction(Long.parseLong(id));
		return prepareResponse(data);
	}
	
	/**
	 * Deleting transaction 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path="/transaction/{id}")
	public BaseVo deleteTransaction(@PathVariable("id") String id) {
		transactionService.deleteTransaction(Long.parseLong(id)); 
		return prepareResponse();
	}
	
	/**
	 * Creating or Updating the User
	 * 
	 * @param transaction
	 * @return
	 */
	@PostMapping("/transaction")
    public BaseVo saveTransaction(@Valid @RequestBody TransactionInfo transaction) {
		logger.debug("Transaction is -->",transaction);
		TransactionInfo data=transactionService.save(transaction);
		return prepareResponse(data);
    }

}
