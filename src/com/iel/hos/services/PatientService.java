package com.iel.hos.services;

import java.io.IOException;
import java.util.List;

import com.iel.hos.beans.Patient;
import com.iel.hos.dao.PatientDao;

public class PatientService {
	private PatientDao patientDao;
	
	public PatientService(){
		this.patientDao = new PatientDao();
	}
	
	public int addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.addPatient(patient);
	}

	public int delPatient(Patient patient) {
		// TODO Auto-generated method stub
		
		return patientDao.delPatient(patient);
	}

	public int modifyUser(Patient patient) {
		// TODO Auto-generated method stub
		
		return patientDao.modifyPatient(patient);
	}

	public List<Patient> searchall() throws IOException {
		// TODO Auto-generated method stub
		return patientDao.searchall();
	}
}
