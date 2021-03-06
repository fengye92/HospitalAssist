package com.iel.hos.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.iel.hos.beans.PageUtil;
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

	@SuppressWarnings("unchecked")
	public PageUtil<Patient> searchAll(Map<String,Object> parm, String parm_name) throws IOException {
		// TODO Auto-generated method stub
		PageUtil<Patient> p = new PageUtil<Patient>();
		Map<String,Object> pa = patientDao.searchAll( parm,parm_name);
		p.setData((List<Patient>) (pa.get("pa")));
		p.setTotal((Integer) pa.get("total"));
		return p;
	}
}
