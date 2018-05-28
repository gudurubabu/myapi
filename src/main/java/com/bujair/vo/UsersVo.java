/**
 * 
 */
package com.bujair.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bujair
 *
 */
public class UsersVo extends BaseVo{
	List<UserVo> users;

	public List<UserVo> getUsers() {
		if(users == null)
			users =new ArrayList<>();
		return users;
	}

	public void setUsers(List<UserVo> users) {
		this.users = users;
	}
	
	

}
