/**
 * 
 */
package com.bujair.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bujair.model.UserInfo;

/**
 * @author dguduru
 *
 */
@Repository(value="userRepository")
public interface UserRepository extends JpaRepository<UserInfo, Long> {

}
