/**
 * 
 */
package com.bujair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bujair.dao.CashRepository;
import com.bujair.exception.NoDataFoundException;
import com.bujair.model.CashInfo;

/**
 * @author Bujair
 *
 */
@Service
public class CashService extends MyAPIService {

	@Autowired
	CashRepository cashRepository;

	/**
	 * Getting Cash Data based on the ID provided by Cash
	 * 
	 * @param id
	 * @return
	 */
	public CashInfo getCash(Long id) {
		return cashRepository.findById(id).orElseThrow(() -> new NoDataFoundException("Note", "id", id));
	}

	/**
	 * Getting All Cash Data
	 * 
	 * @return
	 */
	public List<CashInfo> getCash() {
		return cashRepository.findAll();
	}

	/**
	 * 
	 * Saving and Updating the Cash in DB
	 * @param cash
	 * @return
	 */
	public CashInfo save(CashInfo cash) {
		return cashRepository.save(cash);
	}

	public void deleteCash(long parseLong) {
		cashRepository.deleteById(parseLong);
	}
}
