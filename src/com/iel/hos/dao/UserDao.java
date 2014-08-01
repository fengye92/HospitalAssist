package com.iel.hos.dao;

import java.io.IOException;     
import java.util.Map;

import com.iel.hos.beans.User;
          
public class UserDao {       
	private BaseDao baseDao;
	
	public UserDao(){
		baseDao = new BaseDao();
	}
	
	public int checkLogin(String userId, String passwd) throws IOException{    
		Map<String, String> result = null;
		try {
			result =baseDao.getOneCell("user", userId, "info","pwd" );
			//result = baseDao.getOneRecord("user", userId);
			//result = baseDao.getOneRecord("user", userId);
			//for(String a : result.keySet()){
			//	System.out.println(result.get(a));

			//}
			System.out.println(result.get("value"));
			if(result.get("value").equals(passwd)){
				result = baseDao.getOneCell("user", userId, "info", "permission");
				System.out.println(Integer.parseInt(result.get("value")));
				return Integer.parseInt(result.get("value"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int addUser(User user){
		try{
			String[] values = new String[3];
			values[0] = user.getUserName();
			values[1] = "000";
			values[2] = "" + user.getPermission();
			
			String[] family = {"info", "info", "info"};
			String[] column = {"name", "pwd", "permission"};
			
			baseDao.addCellsRecord("user", user.getUserId(), family, column, values);
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delUser(User user){
		try{			
			baseDao.delRecord("user", user.getUserId());
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int ModifyUser(User user){
		try{
			String[] values = new String[3];
			values[0] = user.getUserName();
			values[1] = "000";
			values[2] = "" + user.getPermission();
			
			String[] family = {"info", "info", "info"};
			String[] column = {"name", "pwd", "permission"};
			
			baseDao.addCellsRecord("user", user.getUserId(), family, column, values);
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
