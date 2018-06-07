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
public interface TransactionRepository extends JpaRepository<TransactionInfo, Long> {

}
