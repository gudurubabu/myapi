/**
 * 
 */
package com.bujair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bujair.model.CashInfo;

/**
 * @author Bujair
 *
 */
@Repository
public interface CashRepository extends JpaRepository<CashInfo, Long> {

}
