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
		
			if(result.get("Tag").equals("error")){
				System.out.println("no this rowkey!!");
				return NO_ROWKEY;
			}else{
				if(result.get("info : pwd").equals(passwd)){
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
			values[1] = user.getUserPasswd();
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
			System.out.println(user.getUserName()+user.getDepartment()+user.getPermission()+
					user.getDes()+user.getEmail());
			String[] values = new String[4];
			values[0] = user.getEmail();
			values[1] = user.getDepartment();
			values[2] = user.getDes();
			values[3] = user.getTel();
			
			String[] family = {"info","info","info","info"};
			String[] column = {"emial","department","des","tel"};
			
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
	
	public int EditPwd(String userId,String exPwd,String newPwd)
	{
		Map<String, String> result = null;
		try {
			System.out.println(userId);
			result =baseDao.getOneCell("user", userId, "info","pwd" );
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println(exPwd);
		//System.out.println(this.MD5Hash(exPwd));
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
