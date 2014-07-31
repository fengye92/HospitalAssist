package com.iel.hos.dao;

import java.io.IOException;     
import java.util.ArrayList;     
import java.util.List;
import org.apache.hadoop.conf.Configuration;     
import org.apache.hadoop.hbase.HBaseConfiguration;     
import org.apache.hadoop.hbase.HColumnDescriptor;     
import org.apache.hadoop.hbase.HTableDescriptor;     
import org.apache.hadoop.hbase.KeyValue;     
import org.apache.hadoop.hbase.MasterNotRunningException;     
import org.apache.hadoop.hbase.ZooKeeperConnectionException;     
import org.apache.hadoop.hbase.client.Delete;     
import org.apache.hadoop.hbase.client.Get;     
import org.apache.hadoop.hbase.client.HBaseAdmin;     
import org.apache.hadoop.hbase.client.HTable;     
import org.apache.hadoop.hbase.client.Result;     
import org.apache.hadoop.hbase.client.ResultScanner;     
import org.apache.hadoop.hbase.client.Scan;     
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;     
          
    public class DoctorsDao {       
    	private static Configuration configuration;
    	
        public void checkLogin() throws IOException{ 
        	
        	configuration = null;    
			configuration =HBaseConfiguration.create();  
			configuration.set("hbase.zookeeper.quorum", "192.168.0.201");

			configuration.set("hbase.zookeeper.property.clientPort", "2181");

			configuration.set("hbase.master", "192.168.0.201");
			
			String column[] = new String[2] ;
			column[0]="test1";
			column[1]="test2";
			try {
				this.creatTable("wyktest", column);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        
        @SuppressWarnings("resource")
		public static void creatTable(String tableName, String[] familys) throws Exception {    
        	System.out.println(configuration.get("hbase.zookeeper.quorum"));
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