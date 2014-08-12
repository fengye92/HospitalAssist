package com.iel.hos.actions;

import javax.servlet.http.HttpServletRequest;
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
	
	public UserAction()
	{
		userService = new UserService();
	}
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
	public void setSession()
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		user.setUserName(userService.getUserOneCell(user.getUserId(), "name"));
		session.setAttribute("username", user.getUserName());
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("userPwd", user.getUserPasswd());
		session.setAttribute("userPermission", user.getPermission());
	}
	/**
	 *   @return
	 *    @throws Exception 
	 *   */
	
	public String checkLogin() throws Exception{
		this.user.setPermission(this.userService.checkLogin(user));
		
		if(this.user.getPermission() == 3){
			setSession();
			return "success3";
		}
		else if(this.user.getPermission()==2)
		{
			setSession();
			return "success3";
		}
		else if(this.user.getPermission()==1)
		{
			setSession();
			return "success1";
		}
		else
		{
			return "error";			
		}

	}

	public String addUser() throws Exception{
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
		this.userService.delUser(user);
		return "success";
	}
	
	public String ModifyUser() throws Exception{
		this.userService.modifyUser(user);
		return "success";
	}

	public String editPwd()throws Exception{
		int rs=this.userService.editPwd("2", exPwd,newPwd);
		System.out.print(exPwd+newPwd);
		if(rs==1)
		{
			System.out.println("修改成功");
			return "success";
		}
		else
		{
			// ServletActionContext.getRequest().setAttribute("result", "error");
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("result", "error");
			 return "error";
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