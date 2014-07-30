package com.iel.hos.actions;

import com.iel.hos.beans.Doctor;
import com.iel.hos.services.DoctorsService;

public class DoctorsAction {

	private DoctorsService docService;
	private Doctor doc;
	
	/**
	   * µÇÂ¼
	   * @return
	 * @throws Exception 
	   */
	public String checkLogin() throws Exception{
			
		System.out.println(doc.getDocName());
		System.out.println(doc.getDocPasswd());
		this.docService=new DoctorsService();
		this.docService.checkLogin(doc);
		return "success";
		
	}
		
	public Doctor getDoc() {
		return doc;
	}
	public void setDoc(Doctor doc) {
		this.doc = doc;
	}
}
