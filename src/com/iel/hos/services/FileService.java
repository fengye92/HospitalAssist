package com.iel.hos.services;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import com.iel.hos.dao.FileDao;
import com.iel.hos.dao.UserDao;

public class FileService {
	FileDao fileDao;
	UserDao userDao;
	
	public boolean checkMD5(String user) throws IOException {
		// TODO Auto-generated method stub
		fileDao = new FileDao();
		
		userDao = new UserDao();
		
		Map<String, String> result = userDao.getUserFile(user);

		if(result.get("Tag").equals("success")){
			int count = Integer.parseInt(result.get("FileCount"));
			
			if(count != 0){
				String[] localPath = new String[count];
				for(int i = 1; i<=count; i++){
					localPath[i-1] = result.get("LocalPath"+i);
				}
				
				checkLocalFile(localPath);
				fileDao.getAndCheck(localPath);
			}
		}
		
		return false;
	}

	public boolean updateFile(File uploadfile) {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	private String[] checkLocalFile(String[] localPath){
		int size = localPath.length;
		String[] result = new String[size];
		
		for(int i = 0; i < size; i++){
			if(new File(localPath[i]).exists()){
				result[i] = "1";
			}else{
				result[i] = "0";
			}
		}
		
		return result;
	}
}
