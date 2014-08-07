package com.iel.hos.dao;

import java.io.IOException;     
import java.util.Map;

import com.iel.hos.beans.User;
          
public class UserDao {       
	private BaseDao baseDao;
	private static int NO_ROWKEY = -1;
	private static int WRONG_PWD = 0;
	
	public UserDao(){
		baseDao = new BaseDao();
	}
	
	public int checkLogin(String userId, String passwd) throws IOException{    
		Map<String, String> result = null;
		try {

			result = baseDao.getOneRecord("user", userId);
			//result = baseDao.getOneCell("user", userId, "info","pwd" );

			//result = baseDao.getOneRecord("user", userId);
			//result = baseDao.getOneRecord("user", userId);
			//for(String a : result.keySet()){
			//	System.out.println(result.get(a));

			//}
			if(result.get("Tag").equals("error")){
				System.out.println("no this rowkey!!");
				return NO_ROWKEY;
			}else{
				if(result.get("info : pwd").equals(passwd)){
					System.out.println(Integer.parseInt(result.get("info : pwd")));
					return Integer.parseInt(result.get("info : permission"));
				}else{
					System.out.println("wrong pwd!!");
					return WRONG_PWD;
				}
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
			
			if(baseDao.checkIsExist("user", user.getUserId())==0){
				baseDao.addCellsRecord("user", user.getUserId(), family, column, values);
				return 1;
			}else{
				System.out.println("This UserId exists!");
				return -1;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int modifyUser(User user){
		try{
			String[] values = new String[3];
			values[0] = user.getUserName();
			values[1] = user.getUserPasswd();
			values[2] = "" + user.getPermission();
			
			String[] family = {"info", "info", "info"};
			String[] column = {"name", "pwd", "permission"};
			
			if(baseDao.checkIsExist("user", user.getUserId())== 1){
				baseDao.addCellsRecord("user", user.getUserId(), family, column, values);
				return 1;
			}else{
				System.out.println("This UserId doesn't exist!");
				return -1;
			}
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
			values[1] = user.getUserPasswd();
			values[2] = "" + user.getPermission();
			
			String[] family = {"info", "info", "info"};
			String[] column = {"name", "pwd", "permission"};
			
			baseDao.addCellsRecord("user", user.getUserId(), family, column, values);
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int EditPwd(String userId,String exPwd,String newPwd)
	{
		System.out.print("bearbearsw");
		Map<String, String> result = null;
		try {
			result =baseDao.getOneCell("user", userId, "info","pwd" );
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(exPwd.equals(result.get("value")))
		{
			System.out.print("lylsuccess");
			try {
				baseDao.addOneCellRecord("user", userId, "info", "pwd", newPwd);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;
		}
		else{
			return 0;
		}
	}
	
	public String getUserOneCell(String userId, String attr) {
		// TODO Auto-generated method stub
		Map<String, String> result = null;

		try {
			result = baseDao.getOneCell("user", userId, "info",attr );
			
			System.out.println(result.get("value"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.get("value");
	}
}
