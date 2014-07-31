package com.iel.hos.services;

import java.util.Map;
import com.iel.hos.beans.Doctor;
import com.iel.hos.dao.BaseDao;
import com.iel.hos.dao.DoctorsDao;

public class DoctorsService {
	private DoctorsDao docDao;
	

	public Map<String, String> checkLogin(Doctor doc) throws Exception{
		//docDao=new DoctorsDao();
		BaseDao base=new BaseDao();
		base.deleteTable("wuyunkun");
		String column[] = new String[3] ;
		column[0]="test1.sad";
		column[1]="test1.happy";
		column[2]="test2";
		base.creatTable("columnTest", column);
		base.addColumnFamily("columnTest", "test3");
		
		//base.addRecord("wyktest", "111", "test1", "", "2014/7/30");
		//base.addRecord("wyktest", "111", "test2", "", "2014/7/31");
		base.getAllRecord("wyktest");
		
		//base.creatTable("aasf", column);
		//docDao.checkLogin();

		return null;
	}
}
