package com.iel.hos.actions;

import com.iel.hos.beans.User;
import com.iel.hos.services.UserService;

public class UserAction {

	private UserService userService;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 *   @return
	 *    @throws Exception 
	 *   */
	
	public String checkLogin() throws Exception{

		this.userService = new UserService();
		this.user.setPermission(this.userService.checkLogin(user));
		
		return "success";

	}
	
	public String addUser() throws Exception{
		this.userService = new UserService();
		this.userService.addUser(user);
		return "success";
	}
	
	public String delUser() throws Exception{
		this.userService = new UserService();
		this.userService.delUser(user);
		return "success";
	}
	
	public String ModifyUser() throws Exception{
		this.userService = new UserService();
		this.userService.modifyUser(user);
		return "success";
	}
}
