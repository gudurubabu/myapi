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
 * @author dguduru
 *
 */
@Service
public class UserService extends MyAPIService{

	@Autowired(required=false)
	UserRepository userRepository;

	public BaseVo getUser(Long id){
		UserInfo userData = userRepository.findById(id)
        .orElseThrow(() -> new NoDataFoundException("Note", "id", id));
		 return convertUserInfoToUser(userData);
	}
	
	public BaseVo getUser(){
		List<UserInfo> usersData = userRepository.findAll();
		 return convertUserInfoListToUserList(usersData);
	}

	private UsersVo convertUserInfoListToUserList(List<UserInfo> usersData) {
		UsersVo  users=new UsersVo();
		usersData.stream().forEach((usermodel)  -> {
			users.getUsers().add(convertUserInfoToUser(usermodel));
		});
		return users;
	}

	private UserVo convertUserInfoToUser(UserInfo userData) {
		UserVo userVo = new UserVo();
		userVo.setUserName(userData.getUserName());
		userVo.setPassword(userData.getPassword());
		userVo.setId(userData.getId());
		return userVo;
	}

	public UserVo save(UserVo user) {
		UserInfo userData = userRepository.save(convertUserToUserInfo(user));
		return convertUserInfoToUser(userData);
	}

	private UserInfo convertUserToUserInfo(UserVo user) {
		UserInfo useModel = new UserInfo();
		useModel.setUserName(user.getUserName());
		useModel.setPassword(user.getPassword());
		return useModel;
	}
}
