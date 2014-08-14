package com.iel.hos.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.iel.hos.beans.Patient;
import com.iel.hos.services.PatientService;

public class PatientAction {
	private PatientService patientService;
	private Patient patient;
	  
	
	public String addPatient() throws Exception{
		this.patientService = new PatientService();

		if(this.patientService.addPatient(patient)==1){
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("message", "success");
			return "success";
		}else{
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("message", "error");
			return "error";
		}
	}
	
	public String delPatient() throws Exception{
		this.patientService = new PatientService();
		this.patientService.delPatient(patient);
		return "success";
	}
	
	public String ModifyPatient() throws Exception{
		this.patientService = new PatientService();
		this.patientService.modifyUser(patient);
		return "success";
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String searchall() throws IOException
	{
		this.patientService = new PatientService();
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Patient> patients=patientService.searchall();
		request.setAttribute("patients", patients);
		return "success";
	}
}
