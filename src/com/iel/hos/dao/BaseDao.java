package com.iel.hos.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;  
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;  
import org.apache.hadoop.hbase.HColumnDescriptor;  
import org.apache.hadoop.hbase.HTableDescriptor;  
import org.apache.hadoop.hbase.TableName;
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
	 *  新建一个表，参数tableName 和 column family 
	 */
	public static void creatTable(String tableName, String[] familys) throws Exception {       
		
		HBaseAdmin admin = new HBaseAdmin(conf);       
	
		if (admin.tableExists(tableName)) {       
			System.out.println("table already exists!");       
		} else {       
			HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf(tableName));       
			for(int i=0; i<familys.length; i++){       
				tableDesc.addFamily(new HColumnDescriptor(familys[i]));       
			}       
			admin.createTable(tableDesc);       
			System.out.println("create table " + tableName + " ok.");       
		}        
	}
	
	/*
	 * 添加一个cell记录
	 * 参数 表名， 行键， 列族名，列名，值
	 */
	
	public int addOneCellRecord (String tableName, String rowKey, String family, String qualifier, String value)throws Exception{       
		try {       
			HTable table = new HTable(conf, tableName); 
			
			Put put = new Put(Bytes.toBytes(rowKey));       
			put.add(Bytes.toBytes(family),Bytes.toBytes(qualifier),Bytes.toBytes(value));       
			table.put(put);     
			
			System.out.println("insert recored " + rowKey + " to table " + tableName +" ok.");       
			
			return 0;
		} catch (IOException e) {       
			e.printStackTrace();       
		}       
		return 0;
	}
	
	/*
	 * 添加多个记录
	 * 参数 表名， 行键， 列族名，列名，值
	 */
	
	public int addCellsRecord (String tableName, String rowKey, String family[], String qualifier[], String value[])throws Exception{       
		try {       
			HTable table = new HTable(conf, tableName); 
			
			Put put = new Put(Bytes.toBytes(rowKey));
			for(int i=0; i < family.length; i++){
				put.add(Bytes.toBytes(family[i]),Bytes.toBytes(qualifier[i]),Bytes.toBytes(value[i]));       
			}
			table.put(put);     
			
			System.out.println("insert recored " + rowKey + " to table " + tableName +" ok.");       
			
			return 0;
		} catch (IOException e) {       
			e.printStackTrace();       
		}       
		return 0;
	}
	/*
	 * 删除一条记录
	 * 参数 表名， 行键
	 */
	 @SuppressWarnings("unchecked")
	public void delRecord (String tableName, String rowKey) throws IOException{       
		HTable table = new HTable(conf, tableName);       
		
		@SuppressWarnings("rawtypes")
		List list = new ArrayList();       
		Delete del = new Delete(rowKey.getBytes());       
		
		list.add(del);       
		table.delete(list);       
		System.out.println("del recored " + rowKey + " ok.");       
	}
	
	/*
	 * 查询一行记录
	 * 参数 表名， 行键
	 */
	public Map<String, String> getOneRecord (String tableName, String rowKey) throws IOException{       
		HTable table = new HTable(conf, tableName); 
		System.out.println(tableName + rowKey);
		Get get = new Get(rowKey.getBytes());    
		
		Map<String,String> result = new HashMap<String,String>();

		Result rs = table.get(get);  
		
		if(rs.isEmpty()){
			result.put("Tag", "error");
			return result;
		}else{
			result.put("Tag", "success");
			for(Cell cell : rs.rawCells()){
				
				byte[] temp =  cell.getFamilyArray();
				String family = new String(subByteArray(temp, cell.getFamilyOffset(), cell.getFamilyLength()));
				
				temp = cell.getQualifierArray();
				String column = new String(subByteArray(temp, cell.getQualifierOffset(), cell.getQualifierLength()));

				temp = cell.getValueArray();
				String value = new String(subByteArray(temp, cell.getValueOffset(), cell.getValueLength()));
				result.put(family +" : " + column, value);	
			}  
			return result;
		}
	}       
	
	/*
	 * 查询某一个cell的数据（没添加时间戳参数，取得的是最新版本的数据）
	 * 参数 表名  行键   family name， column name 
	 */
	public Map<String, String> getOneCell (String tableName, String rowKey, String family, String column) throws IOException{
		HTable table = new HTable(conf, tableName);
		Get get = new Get(rowKey.getBytes());
		
		Map<String, String> result = new HashMap<String, String>();
		
		Result rs = table.get(get);  
		
		result.put("value",new String(rs.getValue(Bytes.toBytes(family), Bytes.toBytes(column))));
		return result;
	}
                 
	/*
	 * 查询表中所有数据
	 *参数 表名
	 */
	public void getAllRecord (String tableName) {       
		try{       
		
			HTable table = new HTable(conf, tableName);    
			Scan s = new Scan();  

			ResultScanner ss = table.getScanner(s);       

			for(Result r:ss){       
				for(Cell cell : r.rawCells()){       
					System.out.print(new String(cell.getRowArray()) + " ");       
					System.out.print(new String(cell.getFamilyArray()) + ":");       
					System.out.print(new String(cell.getQualifierArray()) + " ");       
					System.out.print(cell.getTimestamp() + " ");       
					System.out.println(new String(cell.getValueArray()));       
				}       
			}       
		} catch (IOException e){       
			e.printStackTrace();       
		}       
	}
    
	/*
	* 删除一个表
	* 参数 表名
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
			HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf(tableName));       
			tableDesc.addFamily(new HColumnDescriptor(family));       
			
			System.out.println("add column family in " + tableName + " ok.");       
		} else {       
			System.out.println("No this table");
			return false;
		}
		return true;
	}
	
	public byte[] subByteArray(byte[] array, int start, int length){
		if (array.length > start && start + length <= array.length ){
			byte[] sub = new byte[length];
			
			for(int i=0; i<length; i++){
				sub[i] = array[start+i];
			}
			
			return sub;
		}
		return null;
	}
	
	public int checkIsExist (String tableName, String rowKey) throws IOException{       
		HTable table = new HTable(conf, tableName); 

		Get get = new Get(rowKey.getBytes());    
		
		Result rs = table.get(get);  
		
		if(rs.isEmpty()){
			return 0;
		}else{
			return 1;
		}
	}       
}
