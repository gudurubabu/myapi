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

import com.bujair.model.CardInfo;
import com.bujair.service.CardService;
import com.bujair.vo.BaseVo;

/**
 * @author Bujair
 *
 */
@RestController
public class CardController extends MyAPIController{
	
	@Autowired
	CardService cardService;
	
	@GetMapping("/card")
	/**
	 * Getting all the Users 
	 * @return
	 */
	public BaseVo getCard(){
		logger.debug("GET Cards");
		List<CardInfo> data=cardService.getCard();
		return prepareResponse(data);
	}
	
	/**
	 * Getting User data based on ID  
	 * @param id
	 * @return
	 */
	@GetMapping(path="/card/{id}")
	public BaseVo getCard(@PathVariable("id") String id) {
		CardInfo data=cardService.getCard(Long.parseLong(id));
		return prepareResponse(data);
	}
	
	/**
	 * Deleting card 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path="/card/{id}")
	public BaseVo deleteCard(@PathVariable("id") String id) {
		cardService.deleteCard(Long.parseLong(id)); 
		return prepareResponse();
	}
	
	/**
	 * Creating or Updating the User
	 * 
	 * @param card
	 * @return
	 */
	@PostMapping("/card")
    public BaseVo saveCard(@Valid @RequestBody CardInfo card) {
		logger.debug("Card is -->",card);
		CardInfo data=cardService.save(card);
		return prepareResponse(data);
    }

}
