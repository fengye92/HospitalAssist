package com.iel.hos.actions;

import com.iel.hos.services.DoctorsService;

public class DoctorsAction {
	private String user;
	private String passwd;
	private DoctorsService docService;
	
	public void setUser(String user) {
		this.user = user;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	/**
	   * µÇÂ¼
	   * @return
	 * @throws Exception 
	   */
		public String checkLogin() throws Exception{
			System.out.println(user);
			System.out.println(passwd);
			
			this.docService=new DoctorsService();
			this.docService.checkLogin(user,passwd);
			if(this.user.equals("wyk")&&this.passwd.equals("123"))
			return "success";
				else
			return "error";
			
		
		}
}
