package com.iel.hos.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;  
import org.apache.hadoop.hbase.HBaseConfiguration;  
import org.apache.hadoop.hbase.HColumnDescriptor;  
import org.apache.hadoop.hbase.HTableDescriptor;  
import org.apache.hadoop.hbase.KeyValue;  
import org.apache.hadoop.hbase.client.Delete;  
import org.apache.hadoop.hbase.client.Get;  
import org.apache.hadoop.hbase.client.HBaseAdmin;  
import org.apache.hadoop.hbase.client.HTable;  
import org.apache.hadoop.hbase.client.Put;  
import org.apache.hadoop.hbase.client.Result;  
import org.apache.hadoop.hbase.client.ResultScanner;  
import org.apache.hadoop.hbase.client.Scan;  
import org.apache.hadoop.hbase.util.Bytes;  

public class BaseDao {
	private static Configuration conf = null;
	
	public BaseDao(){
		conf = null;
		conf = HBaseConfiguration.create();  
	    conf.set("hbase.zookeeper.property.clientPort", "2181");  
	    conf.set("hbase.zookeeper.quorum", "192.168.0.201");  
	    conf.set("hbase.master", "192.168.0.201:600000"); 
	    System.out.println(conf.get("hbase.zookeeper.quorum"));
	}
	
	/*
	 *  �½�һ��������tableName �� column family 
	 */
	public static void creatTable(String tableName, String[] familys) throws Exception {       
        HBaseAdmin admin = new HBaseAdmin(conf);       
        
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
	
	/*
	 * ���һ����¼
	 * ���� ������ �м��� ��������������ֵ
	 */
	
	public static void addRecord (String tableName, String rowKey, String family, String qualifier, String value)throws Exception{       
	    try {       
	    	HTable table = new HTable(conf, tableName);       
	        Put put = new Put(Bytes.toBytes(rowKey));       
	        put.add(Bytes.toBytes(family),Bytes.toBytes(qualifier),Bytes.toBytes(value));       
	        table.put(put);       
	        System.out.println("insert recored " + rowKey + " to table " + tableName +" ok.");       
	    } catch (IOException e) {       
	        e.printStackTrace();       
	    }       
    }
	
	/*
	 * ɾ��һ����¼
	 * ���� ������ �м�
	 */
	public static void delRecord (String tableName, String rowKey) throws IOException{       
        HTable table = new HTable(conf, tableName);       
        List list = new ArrayList();       
        Delete del = new Delete(rowKey.getBytes());       
        list.add(del);       
        table.delete(list);       
        System.out.println("del recored " + rowKey + " ok.");       
    }
	
	/*
	 * ��ѯһ����¼
	 * ���� ������ �м�
	 */
    public static void getOneRecord (String tableName, String rowKey) throws IOException{       
        HTable table = new HTable(conf, tableName);       
        Get get = new Get(rowKey.getBytes());       
        Result rs = table.get(get);       
        for(KeyValue kv : rs.raw()){       
            System.out.print(new String(kv.getRow()) + " " );       
            System.out.print(new String(kv.getFamily()) + ":" );       
            System.out.print(new String(kv.getQualifier()) + " " );       
            System.out.print(kv.getTimestamp() + " " );       
            System.out.println(new String(kv.getValue()));       
        }       
    }       
                 
    /*
	 * ��ѯ������������
	 *���� ����
	 */
    public static void getAllRecord (String tableName) {       
        try{       
        	 
             HTable table = new HTable(conf, tableName);    
             Scan s = new Scan();  
             System.out.println("0");
             ResultScanner ss = table.getScanner(s);       
             System.out.println("1");
             for(Result r:ss){       
                 for(KeyValue kv : r.raw()){       
                    System.out.print(new String(kv.getRow()) + " ");       
                    System.out.print(new String(kv.getFamily()) + ":");       
                    System.out.print(new String(kv.getQualifier()) + " ");       
                    System.out.print(kv.getTimestamp() + " ");       
                    System.out.println(new String(kv.getValue()));       
                 }       
             }       
        } catch (IOException e){       
            e.printStackTrace();       
        }       
    }
    
    /*
	 * ɾ��һ����
	 * ���� ����
	 */
    public static boolean deleteTable(String tablename) throws IOException {  
        HBaseAdmin admin = new HBaseAdmin(conf);  
        System.out.println(admin.toString());
        if(admin.tableExists(tablename)) {  
            try {  
                admin.disableTable(tablename);  
                admin.deleteTable(tablename);  
                System.out.println(tablename+" delete success.");
            } catch (Exception e) {  
                // TODO: handle exception  
                e.printStackTrace();  
                return false;  
            }  
        }  
        return true;  
    } 
    
    public static boolean addColumnFamily(String tableName,String family) throws IOException{
    	HBaseAdmin admin = new HBaseAdmin(conf);       
        
        if (admin.tableExists(tableName)) {       
        	HTableDescriptor tableDesc = new HTableDescriptor(tableName);       
            tableDesc.addFamily(new HColumnDescriptor(family));       
            
            System.out.println("add column family in " + tableName + " ok.");       
        } else {       
            System.out.println("No this table");
            return false;
        }
        return true;
    }
	
}
