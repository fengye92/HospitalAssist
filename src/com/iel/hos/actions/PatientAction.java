package com.iel.hos.actions;

import com.iel.hos.beans.Patient;
import com.iel.hos.services.PatientService;

public class PatientAction {
	private PatientService patientService;
	private Patient patient;
	  
	
	public String addPatient() throws Exception{
		this.patientService = new PatientService();

		if(this.patientService.addPatient(patient)==1){
			
			return "success";
		}else{
			return "success";
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

}
