/**
 * 
 */
package com.bujair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bujair.dao.UserRepository;
import com.bujair.exception.NoDataFoundException;
import com.bujair.model.UserInfo;
import com.bujair.util.PasswordUtil;

/**
 * @author Bujair
 *
 */
@Service
public class UserService extends MyAPIService {

	@Autowired(required = false)
	UserRepository userRepository;

	@Value("${com.salt}")
	private String SALTKEY;

	/**
	 * Getting User Data based on the ID provided by User
	 * 
	 * @param id
	 * @return
	 */
	public UserInfo getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new NoDataFoundException("Note", "id", id));
	}

	/**
	 * Getting All User Data
	 * 
	 * @return
	 */
	public List<UserInfo> getUser() {
		return userRepository.findAll();
	}

	/**
	 * Savind and Updating the User in DB
	 * 
	 * @param user
	 * @return
	 */
	public UserInfo save(UserInfo user) {
		if(null != user && null != user.getPassword())
			user.setPassword(PasswordUtil.generateSecurePassword(user.getPassword(), SALTKEY));
		return userRepository.save(user);
	}

	public void deleteUser(long parseLong) {
		userRepository.deleteById(parseLong);
	}
}
