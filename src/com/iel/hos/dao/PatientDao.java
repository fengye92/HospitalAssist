package com.iel.hos.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.PrefixFilter;

import com.iel.hos.beans.Patient;

public class PatientDao extends BaseDao{

	public int addPatient(Patient patient) {
		// TODO Auto-generated method stub
		try{
			String[] values = new String[6];
			values[0] = patient.getName();
			values[1] = "" + patient.getAge();
			values[2] = "" + patient.getGender();
			values[3] = patient.getIdNum();
			values[4] = patient.getTelephone();
			values[5] = patient.getAddress();
			
			String[] family = {"patientinfo", "patientinfo", "patientinfo","patientinfo","patientinfo","patientinfo"};
			String[] column = {"name", "age", "gender","idNum","telephone","address"};
			
			if(this.checkIsExist("patient", patient.getId())==0){
				this.addCellsRecord("patient", patient.getId(), family, column, values);
				return 1;
			}else{
				System.out.println("This patient exists!");
				return -1;
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	public int delPatient(Patient patient) {
		// TODO Auto-generated method stub
		try{			
			this.delRecord("patient", patient.getId());
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}

	public int modifyPatient(Patient patient) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Map<String, Object> searchAll(Map<String,Object> parm, String sSearch) throws IOException {
		// TODO Auto-generated method stub
		HTable table = new HTable(getConf(), "patient"); 
		int size ;
		int curPage ;
		
		if(parm.get("size")==null||Integer.parseInt((String) parm.get("size"))== 0L){
			size = 10;
		}else{
			size = Integer.parseInt((String) parm.get("size"));
		}
		if(parm.get("curPage") == null || (Integer) parm.get("curPage")== 0L){
			curPage = 1;
		}else{
			curPage = (Integer) parm.get("curPage");
		}
		
		
		int firstRow = (curPage-1)*size;
		int endRow = firstRow+size;
		Scan s = new Scan(); 
		//s.setFilter(new FirstKeyOnlyFilter());
		if(sSearch != null && !sSearch.equals("") ){
			s.setFilter(new PrefixFilter(sSearch.getBytes()));
		}
		s.setCaching(1000);
		s.setCacheBlocks(false);
		
		List<Patient> patients=new LinkedList<Patient>();
		ResultScanner ss = table.getScanner(s);
		int i = 0;
		Map<String, Object> re = new HashMap<String,Object>();
		
		for(Result r :ss)
		{		    
			if(i>=firstRow && i<endRow){
				Patient p = new Patient();
				String id=new String(r.getRow(),"utf-8");
				p.setId(id);
				for(Cell cell:r.rawCells())
				{
				  	String tmp=new String(CellUtil.cloneQualifier(cell),"utf-8");
				  	String value=new String(CellUtil.cloneValue(cell),"utf-8");
				  	if(tmp.equals("name"))
				  	{
				  		p.setName(value);
				  	}
				  	if(tmp.equals("address"))
				  	{
				  		p.setAddress(value);
				  	}
				  	if(tmp.equals("age"))
				  	{
				  		p.setAge(Integer.parseInt(value));
				  	}
				  	if(tmp.equals("gender"))
				  	{
				  		p.setGender(Integer.parseInt(value));
				  	}
				  	if(tmp.equals("tel"))
				  	{
				  		p.setTelephone(value);
				  	}
				  	if(tmp.equals("idnumber"))
				  	{
				  		p.setIdNum(value);
				  	}
				}
				patients.add(p);
			}
			i++;
		}
		re.put("total", i);
		re.put("pa", patients);
		ss.close();
		System.out.println(patients.size());
	
		return re;
	}

}
