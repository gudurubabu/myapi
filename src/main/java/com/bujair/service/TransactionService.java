/**
 * 
 */
package com.bujair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bujair.dao.TransactionsRepository;
import com.bujair.exception.NoDataFoundException;
import com.bujair.model.TransactionInfo;

/**
 * @author Bujair
 *
 */
@Service
public class TransactionService extends MyAPIService {

	@Autowired
	TransactionsRepository transactioRepository;

	/**
	 * Getting Transaction Data based on the ID provided by Transaction
	 * 
	 * @param id
	 * @return
	 */
	public TransactionInfo getTransaction(Long id) {
		return transactioRepository.findById(id).orElseThrow(() -> new NoDataFoundException("Note", "id", id));
	}

	/**
	 * Getting All Transaction Data
	 * 
	 * @return
	 */
	public List<TransactionInfo> getTransaction() {
		return transactioRepository.findAll();
	}

	/**
	 * 
	 * Saving and Updating the Transaction in DB
	 * @param transaction
	 * @return
	 */
	public TransactionInfo save(TransactionInfo transaction) {
		return transactioRepository.save(transaction);
	}

	public void deleteTransaction(long parseLong) {
		transactioRepository.deleteById(parseLong);
	}
}
