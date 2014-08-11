package com.iel.hos.dao;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;

import com.iel.hos.beans.Patient;

public class PatientDao extends BaseDao{

	public int addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delPatient(Patient patient) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int modifyPatient(Patient patient) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Patient> searchall() throws IOException {
		// TODO Auto-generated method stub
		HTable table = new HTable(this.getConf(), "patient");    
		Scan s = new Scan();  
		List<Patient> patients=new LinkedList<Patient>();
		ResultScanner ss = table.getScanner(s);
		
		for(Result r :ss)
		{
			System.out.println("\n rowlalallala"+new String(r.getRow()));
			Patient p = new Patient();
			String id=new String(r.getRow(),"utf-8");
			p.setId(id);
			for(KeyValue kv:r.raw())
			{
			  	String tmp=new String(kv.getQualifier(),"utf-8");
			  	String value=new String(kv.getValue(),"utf-8");
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
			System.out.println("创建完毕"+p.getId()+p.getName()+p.getAddress()+p.getGender()+p.getAge()+p.getIdNum()
					+p.getTelephone());
			patients.add(p);
		}
		ss.close();
		return patients;
	}

}
