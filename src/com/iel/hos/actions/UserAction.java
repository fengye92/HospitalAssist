package com.iel.hos.actions;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	private String des;
	private String tel;
	private String email;
	private String department;
	
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
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
	
	public void setSession() throws UnsupportedEncodingException
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		user.setUserName(userService.getUserOneCell(user.getUserId(), "name"));
		user.setDepartment(userService.getUserOneCell(user.getUserId(), "department"));
		user.setTel(userService.getUserOneCell(user.getUserId(), "tel"));
		user.setDes(userService.getUserOneCell(user.getUserId(), "des"));
		user.setEmail(userService.getUserOneCell(user.getUserId(), "emial"));
		session.setAttribute("username", user.getUserName());
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("userPwd", user.getUserPasswd());
		session.setAttribute("userPermission", user.getPermission());
		session.setAttribute("tel", user.getTel());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("department", URLDecoder.decode(user.getDepartment(), "UTF-8"));
		session.setAttribute("des", user.getDes());
	}
	/**
	 *   @return
	 *    @throws Exception 
	 *   */
	
	public String checkLogin() throws Exception{
		user.setUserPasswd(MD5Hash(user.getUserPasswd()));
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
			return "success3";
		}
		else
		{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("result", "error");
			return "error";			
		}

	}

	public String addUser() throws Exception{
		System.out.println(user.getPermission());
		System.out.println(user.getUserName());
		user.setUserPasswd(MD5Hash("000"));

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
		HttpSession session = ServletActionContext.getRequest().getSession();
		String mdNewPwd = MD5Hash(newPwd);
		
		int rs=this.userService.editPwd((String)session.getAttribute("userId"), MD5Hash(exPwd),mdNewPwd);
		System.out.print(exPwd+newPwd);
		if(rs==1){
			System.out.println("修改成功");
			session.setAttribute("userPwd", mdNewPwd);
			return "success";
		}else{
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
		session.removeAttribute("tel");
		session.removeAttribute("department");
		session.removeAttribute("des");
		session.removeAttribute("email");
		return "success";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String editInfo(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		User newUser = new User();
		newUser.setUserId((String)session.getAttribute("userId"));
		newUser.setDepartment(department);
		newUser.setDes(des);
		newUser.setEmail(email);
		newUser.setTel(tel);
		session.setAttribute("department", department);
		session.setAttribute("tel", tel);
		session.setAttribute("des", des);
		session.setAttribute("email", email);
		int i=userService.editInfo(newUser);
		if(i==1){
			return "success";
		}
		else{
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("result", "error");
			return "error";
		}
	}
	
	private String MD5Hash(String input){
		String result = "";
		if(input != null){
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] results = md.digest(input.getBytes());   
				String resultString = byteArrayToHexString(results);  
                return resultString.toUpperCase(); 
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result; 
	}
	
	private static String byteArrayToHexString(byte[] b){  
        StringBuffer resultSb = new StringBuffer();  
        for (int i = 0; i < b.length; i++){  
            resultSb.append(byteToHexString(b[i]));  
        }  
        return resultSb.toString();  
    }  
      
    private static String byteToHexString(byte b){  
    	final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int n = b;  
        if (n < 0)  
            n = 256 + n;  
        int d1 = n / 16;  
        int d2 = n % 16;  
        return hexDigits[d1] + hexDigits[d2];  
    }
}