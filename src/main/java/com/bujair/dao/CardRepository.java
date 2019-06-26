/**
 * 
 */
package com.bujair.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bujair.model.CardInfo;

/**
 * @author Bujair
 *
 */
@Repository
public interface CardRepository extends JpaRepository<CardInfo, Long> {

}
