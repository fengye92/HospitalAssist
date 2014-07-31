package com.iel.hos.dao;

import java.io.IOException;     
import java.util.ArrayList;     
import java.util.List;
import org.apache.hadoop.conf.Configuration;     
import org.apache.hadoop.hbase.HBaseConfiguration;     
import org.apache.hadoop.hbase.HColumnDescriptor;     
import org.apache.hadoop.hbase.HTableDescriptor;         
import org.apache.hadoop.hbase.client.HBaseAdmin;     
    
          
public class DoctorsDao {       
	private static Configuration configuration;
	
	
	public void checkLogin() throws IOException{    
		configuration = null;    
		configuration =HBaseConfiguration.create();  
		configuration.set("hbase.zookeeper.quorum", "192.168.0.201");
		configuration.set("hbase.zookeeper.property.clientPort", "2181");
		configuration.set("hbase.master", "192.168.0.201");
		System.out.println(configuration.get("hbase.zookeeper.quorum"));
		
		String column[] = new String[2] ;
		column[0]="test1";
		column[1]="test2";
		
		try {
			this.creatTable("wyktest1", column);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void creatTable(String tableName, String[] familys) throws Exception {       
		HBaseAdmin admin = new HBaseAdmin(configuration);       
		if (admin.tableExists(tableName)) {       
			System.out.println("table already exists!");       
		} else {       
			HTableDescriptor tableDesc = new HTableDescriptor(tableName);       
			for(int i=0; i<familys.length; i++){       
				tableDesc.addFamily(new HColumnDescriptor(familys[i]));       
				
			}       
			
			admin.createTable(tableDesc);       
			System.out.println("create table " + tableName + " ok.");       
			
		}        
		
	}   
}
