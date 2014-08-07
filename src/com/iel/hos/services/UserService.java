package com.iel.hos.services;

import com.iel.hos.beans.User;
import com.iel.hos.dao.UserDao;

public class UserService {
	private UserDao userDao;
	

	public int checkLogin(User user) throws Exception{
		userDao = new UserDao();
		
		return userDao.checkLogin(user.getUserId(),user.getUserPasswd());
	}
	
	public int addUser(User user) throws Exception{
		userDao = new UserDao();
		
		return userDao.addUser(user);
	}

	public int delUser(User user) {
		// TODO Auto-generated method stub
		userDao = new UserDao();
		
		return userDao.delUser(user);
	}

	public int modifyUser(User user) {
		// TODO Auto-generated method stub
		userDao = new UserDao();
		
		return userDao.addUser(user);
	}
	public int editPwd(String userId,String exPwd, String newPwd)
	{
		userDao = new UserDao();
		return userDao.EditPwd(userId, exPwd,newPwd);
	}
}
