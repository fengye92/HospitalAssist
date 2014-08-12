package com.iel.hos.beans;
import org.apache.hadoop.fs.FileStatus;

public class FileBean {
		
	private String hdfsPath;
	private long fileSize;
	private long modifyTime;	
	private String fileName;
	private String fileDir;
	private boolean isDir;

	public FileBean(FileStatus fileStatus){
		hdfsPath = fileStatus.getPath().toString();
		fileSize = fileStatus.getLen();
		modifyTime = fileStatus.getModificationTime();
		fileName = fileStatus.getPath().getName();
		fileDir = fileStatus.getPath().getParent().getName();
		isDir = fileStatus.isDir();
	}	
	
	public String getHdfsPath() {
		return hdfsPath;
	}
	
	public long getFileSize() {
		return fileSize;
	}

	public long getModifyTime() {
		return modifyTime;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getFileDir() {
		return fileDir;
	}
	
	public boolean isDir() {
		return isDir;
	}
	
	public String toString(){
		return hdfsPath;
	}
}