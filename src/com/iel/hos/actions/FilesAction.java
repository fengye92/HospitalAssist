package com.iel.hos.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.iel.hos.beans.HDFSConfig;
import com.iel.hos.beans.HDFSOperation;
import com.iel.hos.services.FileService;


public class FilesAction {
	/** 
	 */
	private File uploadfile;
	private String uploadfileFileName;
	private String uploadfileContentType;
	private String md5String;
	
	public String doPost() throws IOException {
		// Check that we have a file upload request	
		System.out.println(this.uploadfileFileName);
	    
	    FileInputStream uploadedStream = new FileInputStream(this.uploadfile);
	    HDFSOperation hdfsOperation = new HDFSOperation();
		System.out.println(this.uploadfileFileName);

	    String hdfsPath = HDFSConfig.getHDFSPath() + this.uploadfileFileName;
	    boolean flag = hdfsOperation.upLoad(uploadedStream, hdfsPath);	
		System.out.println(flag);

	    if(flag){
	    	return "success";
	    }else{
	    	return "error";
	    }
	}

	public String checkMD5() throws IOException{
		FileService fs = new FileService();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String user = (String) session.getAttribute("username");
		
		boolean result = fs.checkMD5(user);
		
		
		return "success";
	}
	
	public String updateFile(){
		FileService fs = new FileService();
		boolean result = fs.updateFile(this.uploadfile);
		
		
		return "success";
	}
	
	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}

	public String getUploadfileContentType() {
		return uploadfileContentType;
	}

	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}

	public String getUploadfileFileName() {
		return uploadfileFileName;
	}

	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}

	public String getMd5String() {
		return md5String;
	}

	public void setMd5String(String md5String) {
		this.md5String = md5String;
	}

}
