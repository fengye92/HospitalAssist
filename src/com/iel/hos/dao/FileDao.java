package com.iel.hos.dao;

import java.io.IOException;
import java.util.Map;

public class FileDao extends BaseDao {

	/*
	 * 	check files with localPath
	 *  if no this localPath, error, this file has 
	 */
	
	public String getAndCheck(String[] filePath) throws IOException {
		// TODO Auto-generated method stub
		int size = filePath.length;
		String[] result = new String[size];
		
		for(int i = 0; i < size; i++){
			Map<String, String> temp = this.getOneRecord("public_file", filePath[i]);
			if(temp.get("Tag").equals("error")){
				result[i] = "error";
			}else{
			}
		}		
		
		return null;
	}
	
}
