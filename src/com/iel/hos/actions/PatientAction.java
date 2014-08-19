package com.iel.hos.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.iel.hos.beans.DataTableReturnObject;
import com.iel.hos.beans.PageUtil;
import com.iel.hos.beans.Patient;
import com.iel.hos.services.PatientService;

public class PatientAction {
	private PatientService patientService;
	private Patient patient;
	private String[][] aaData;   //这是实际读入表格的数据
	private DataTableReturnObject tableReturnObject = null;
	private String parm_name;
	
	public DataTableReturnObject getTableReturnObject() {
		return tableReturnObject;
	}

	public void setTableReturnObject(DataTableReturnObject tableReturnObject) {
		this.tableReturnObject = tableReturnObject;
	}
	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public String[][] getAaData() {
		return aaData;
	}

	public void setAaData(String[][] aaData) {
		this.aaData = aaData;
	}

	public String getParm_name() {
		return parm_name;
	}

	public void setParm_name(String parm_name) {
		this.parm_name = parm_name;
	}

	
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
		int total = 0;
		List<Patient> patients = null;
		String sEcho = null, iDisplayStart = null, iDisplayLength= null;
		
		try{
			Map<String,Object> params = new HashMap<String, Object>();
			
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();  

	        response.setCharacterEncoding("UTF-8");  
	        
	                
	        sEcho = request.getParameter("sEcho");
	        iDisplayStart = request.getParameter("iDisplayStart");
	        iDisplayLength = request.getParameter("iDisplayLength");
	        
			System.out.println(sEcho + " iDisplayStart "+iDisplayStart+" iDisplay"+ iDisplayLength);
			int cup = (int)(Integer.parseInt(iDisplayStart)/10) + 1;
			
			params.put(PageUtil.CURPAGE, cup);
			params.put(PageUtil.SIZE, iDisplayLength);
			params.put(PageUtil.STARTPAGE, iDisplayStart);
			PageUtil<Patient> patientUtil = patientService.searchAll(params,parm_name);
			patients = patientUtil.getData();
			total = (int)patientUtil.getTotal();
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		
		//resultArr封装页面要显示的数据和数据的各种格式
		String[][] resultArr = new String[patients.size()][];
		
		for (int i = 0; i < resultArr.length; i++) {
			String[] resultOne = new String[7];   
			Patient pa = patients.get(i);
			String oID = pa.getId();
			resultOne[0] = oID;
			resultOne[1] = pa.getName();
			resultOne[2] = "" + pa.getAge();
			resultOne[3] = "" + (pa.getGender()==1?"男":"女");
			resultOne[4] = (pa.getIdNum()==null?"":pa.getIdNum());
			resultOne[5] = (pa.getTelephone()==null?"":pa.getTelephone());
			resultOne[6] = (pa.getAddress()==null?"":pa.getAddress());
			resultArr[i] = resultOne;
		}
		
		aaData = resultArr;
		tableReturnObject = new DataTableReturnObject(total, total, sEcho, aaData); 
		
		HttpServletResponse response = ServletActionContext.getResponse();  
        response.setCharacterEncoding("utf-8"); 
		response.getWriter().print(tableReturnObject.toJson());
		return null;
		/*this.patientService = new PatientService();
		HttpServletRequest request=ServletActionContext.getRequest();
		List<Patient> patients=patientService.searchall();
		request.setAttribute("patients", patients);*/
		//return "success";
	}
}
