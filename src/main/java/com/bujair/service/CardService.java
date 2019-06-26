/**
 * 
 */
package com.bujair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bujair.dao.CardRepository;
import com.bujair.exception.NoDataFoundException;
import com.bujair.model.CardInfo;

/**
 * @author Bujair
 *
 */
@Service
public class CardService extends MyAPIService {

	@Autowired
	CardRepository cardRepository;

	/**
	 * Getting Card Data based on the ID provided by Card
	 * 
	 * @param id
	 * @return
	 */
	public CardInfo getCard(Long id) {
		return cardRepository.findById(id).orElseThrow(() -> new NoDataFoundException("Note", "id", id));
	}

	/**
	 * Getting All Card Data
	 * 
	 * @return
	 */
	public List<CardInfo> getCard() {
		return cardRepository.findAll();
	}

	/**
	 * 
	 * Saving and Updating the Card in DB
	 * @param card
	 * @return
	 */
	public CardInfo save(CardInfo card) {
		return cardRepository.save(card);
	}

	public void deleteCard(long parseLong) {
		cardRepository.deleteById(parseLong);
	}
}
