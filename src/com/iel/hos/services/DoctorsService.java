package com.iel.hos.services;

import java.util.Map;

import com.iel.hos.dao.DoctorsDao;

public class DoctorsService {
	private DoctorsDao docDao;
	
	public Map<String, String> checkLogin(String user, String passwd) throws Exception{
		docDao=new DoctorsDao();
		
		docDao.checkLogin();
		
		return null;
	}
}
