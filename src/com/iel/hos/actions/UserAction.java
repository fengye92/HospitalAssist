package com.iel.hos.actions;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.iel.hos.beans.User;
import com.iel.hos.services.UserService;

public class UserAction{

	private UserService userService;
	private User user;
	private String exPwd;
	private String newPwd;
	private String message;
	
	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getExPwd() {
		return exPwd;
	}

	public void setExPwd(String exPwd) {
		this.exPwd = exPwd;
	}

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
		
		if(this.user.getPermission() == 3){
			
			HttpSession session = ServletActionContext.getRequest().getSession();
			
			System.out.println(session.getId());
			System.out.println(session.isNew());
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userPwd", user.getUserPasswd());
			session.setAttribute("userPermission", user.getPermission());

		}
		else if(this.user.getPermission()==2)
		{
			return "success2";
		}
		else if(this.user.getPermission()==1)
		{
			return "success1";
		}
		else
		{
			return "error";			
		}
		return "success";

	}

	public String addUser() throws Exception{
		this.userService = new UserService();
		System.out.println(user.getPermission());
		System.out.println(user.getUserName());
		
		if(this.userService.addUser(user)==1){
			
			message="success";
			return "success";
		}else{
			message="existingId";
			return "success";
		}
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

	public String editPwd()throws Exception{
		this.userService = new UserService();
		System.out.print("测试"+exPwd);
		int rs=this.userService.editPwd("1", exPwd,newPwd);
		if(rs==1)
		{
			return "success";
		}
		else
		{
			ServletActionContext.getRequest().setAttribute("result","error");
			return "pwderror";
		}
	}
	
	public String logOut(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		//session.invalidate();
		session.removeAttribute("userId");
		session.removeAttribute("userPwd");
		session.removeAttribute("userPermission");

		return "success";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}