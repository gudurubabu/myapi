/**
 * 
 */
package com.bujair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bujair.dao.UserRepository;
import com.bujair.exception.NoDataFoundException;
import com.bujair.model.UserInfo;
import com.bujair.vo.BaseVo;
import com.bujair.vo.UserVo;
import com.bujair.vo.UsersVo;

/**
 * @author Bujair
 *
 */
@Service
public class UserService extends MyAPIService{

	@Autowired(required=false)
	UserRepository userRepository;

	/**
	 * Getting User Data based on the ID provided by User
	 * 
	 * @param id
	 * @return
	 */
	public BaseVo getUser(Long id){
		UserInfo userData = userRepository.findById(id)
        .orElseThrow(() -> new NoDataFoundException("Note", "id", id));
		 return convertUserInfoListToUserList(userData);
	}
	
	/**
	 * Getting All User Data
	 * 
	 * @return
	 */
	public BaseVo getUser(){
		List<UserInfo> usersData = userRepository.findAll();
		 return convertUserInfoListToUserList(usersData);
	}

	/**
	 * Savind and Updating the User in DB
	 * 
	 * @param user
	 * @return
	 */
	public UserVo save(UserVo user) {
		UserInfo userData = userRepository.save(convertUserToUserInfo(user));
		return convertUserInfoToUser(userData);
	}
	
	/**
	 * Iterating the List of Users in to Users VO 
	 * 
	 * @param usersData
	 * @return
	 */
	private UsersVo convertUserInfoListToUserList(List<UserInfo> usersData) {
		UsersVo  users=new UsersVo();
		usersData.stream().forEach((usermodel)  -> {
			users.getUsers().add(convertUserInfoToUser(usermodel));
		});
		return users;
	}
	
	
	/**
	 * Preparing the User data from  sorted  
	 * 
	 * @param userData
	 * @return
	 */
	private UsersVo convertUserInfoListToUserList(UserInfo userData) {
		UserVo userVo = new UserVo();
		userVo.setUserName(userData.getUserName());
		userVo.setPassword(userData.getPassword());
		userVo.setId(userData.getId());
		UsersVo result = new UsersVo();
		result.getUsers().add(userVo);
		return result;
	}

	/**
	 * Preparing Model  to Vo
	 * 
	 * @param userData
	 * @return
	 */
	private UserVo convertUserInfoToUser(UserInfo userData) {
		UserVo userVo = new UserVo();
		userVo.setUserName(userData.getUserName());
		userVo.setPassword(userData.getPassword());
		userVo.setId(userData.getId());
		return userVo;
	}

	/**
	 * Preparing Vo to Model
	 * 
	 * @param user
	 * @return
	 */
	private UserInfo convertUserToUserInfo(UserVo user) {
		UserInfo useModel = new UserInfo();
		useModel.setUserName(user.getUserName());
		useModel.setPassword(user.getPassword());
		return useModel;
	}
}
