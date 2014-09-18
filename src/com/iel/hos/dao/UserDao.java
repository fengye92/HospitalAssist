package com.iel.hos.dao;

import java.io.IOException;     
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import com.iel.hos.beans.User;
          
public class UserDao extends BaseDao{       
	private static int NO_ROWKEY = -1;
	private static int WRONG_PWD = 0;

	public int checkLogin(String userId, String passwd) throws IOException{

		Map<String, String> result = null;
		try {
			result = this.getOneRecord("user", userId);
		
			if(result.get("Tag").equals("error")){
				System.out.println("no this rowkey!!");
				return NO_ROWKEY;
			}else{
				
				String salt = result.get("info : salt");
				String md5re = MD5Hash(passwd + salt);
				
				if(result.get("info : pwd").equals(md5re)){
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
			String salt = RandomStringUtils.randomAlphabetic(8);
						
			String[] values = new String[4];
			values[0] = user.getUserName();
			values[1] = MD5Hash(user.getUserPasswd() + salt);
			values[2] = "" + user.getPermission();
			values[4] = salt;
			
			String[] family = {"info", "info", "info","info"};
			String[] column = {"name", "pwd", "permission","salt"};
			
			if(this.checkIsExist("user", user.getUserId())==0){
				this.addCellsRecord("user", user.getUserId(), family, column, values);
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
			
			if(this.checkIsExist("user", user.getUserId())== 1){
				this.addCellsRecord("user", user.getUserId(), family, column, values);
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
			this.delRecord("user", user.getUserId());
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int EditPwd(String userId,String exPwd,String newPwd)
	{
		Map<String, String> pwd = null;
		Map<String, String> salt = null;
		try {
			System.out.println(userId);
			pwd =this.getOneCell("user", userId, "info","pwd" );
			salt =this.getOneCell("user", userId, "info","salt" );
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println(exPwd);
		//System.out.println(this.MD5Hash(exPwd));
		if(MD5Hash(exPwd + salt).equals(pwd.get("value")))
		{
			System.out.print("lylsuccess");
			try {
				this.addOneCellRecord("user", userId, "info", "pwd", MD5Hash(newPwd + salt));
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
			result = this.getOneCell("user", userId, "info",attr );
			
			System.out.println(result.get("value"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.get("value");
	}

	public Map<String, String> getUserFile(String user) throws IOException {
		// TODO Auto-generated method stub
		HTable table = new HTable(getConf(), "user"); 
	
		Get get = new Get(user.getBytes());    
		
		Map<String,String> result = new HashMap<String,String>();

		Result rs = table.get(get);  
		
		if(rs.isEmpty()){
			result.put("Tag", "error");
			return result;
		}else{
			result.put("Tag", "success");
			for(Cell cell : rs.rawCells()){
				
				String family = new String(CellUtil.cloneFamily(cell),"utf-8");
				
				if(family.equals("UserFile")){
					String column = new String(CellUtil.cloneQualifier(cell),"utf-8");
					String value =  new String(CellUtil.cloneValue(cell),"utf-8");
					result.put(column, value);
				}
				/*byte[] temp =  cell.getFamilyArray();
				String family = new String(subByteArray(temp, cell.getFamilyOffset(), cell.getFamilyLength()));
				
				temp = cell.getQualifierArray();
				String column = new String(subByteArray(temp, cell.getQualifierOffset(), cell.getQualifierLength()));

				temp = cell.getValueArray();
				String value = new String(subByteArray(temp, cell.getValueOffset(), cell.getValueLength()));*/
			}  
			return result;
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
