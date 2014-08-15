package com.iel.hos.services;

import com.iel.hos.beans.User;
import com.iel.hos.dao.UserDao;

public class UserService {
	private UserDao userDao;
	
	public UserService(){
		userDao = new UserDao();
	}

	public int checkLogin(User user) throws Exception{
		
		return userDao.checkLogin(user.getUserId(),user.getUserPasswd());
	}
	
	public int addUser(User user) throws Exception{
		
		return userDao.addUser(user);
	}

	public int delUser(User user) {
		// TODO Auto-generated method stub
		
		return userDao.delUser(user);
	}

	public int modifyUser(User user) {
		// TODO Auto-generated method stub
		
		return userDao.addUser(user);
	}
	public int editPwd(String userId,String exPwd, String newPwd)
	{
		return userDao.EditPwd(userId, exPwd,newPwd);
	}
	public String getUserOneCell(String userId, String attr)
	{
		return userDao.getUserOneCell(userId, attr);
	}
	public int editInfo(User user)
	{
		return userDao.modifyUser(user);
	}
}
