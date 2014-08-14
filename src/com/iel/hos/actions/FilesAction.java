package com.iel.hos.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import com.iel.hos.beans.HDFSConfig;
import com.iel.hos.beans.HDFSOperation;


public class FilesAction {
	/** 
	 */
	private File uploadfile;
	private String uploadfileFileName;
	private String uploadfileContentType;
	
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

}
