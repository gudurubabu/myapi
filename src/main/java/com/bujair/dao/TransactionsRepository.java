/**
 * 
 */
package com.bujair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bujair.model.TransactionInfo;

/**
 * @author Bujair
 *
 */
@Repository
public interface TransactionsRepository extends JpaRepository<TransactionInfo, Long> {

}
