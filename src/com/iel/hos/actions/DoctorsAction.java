package com.iel.hos.actions;

public class DoctorsAction {
	private String user;
	private String passwd;
	public void setUser(String user) {
		this.user = user;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	/**
	   * µÇÂ¼
	   * @return
	   */
		public String checkLogin(){
			System.out.println(user);
			System.out.println(passwd);
			if(this.user.equals("wyk")&&this.passwd.equals("123"))
			return "success";
				else
			return "error";
		
		}
}
