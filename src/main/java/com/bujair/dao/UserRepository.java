/**
 * 
 */
package com.bujair.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bujair.model.UserInfo;

/**
 * @author Bujair
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
