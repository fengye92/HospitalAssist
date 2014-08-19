package com.iel.hos.beans;

public class DataTableReturnObject {

	 private long iTotalRecords;
	 private long iTotalDisplayRecords;
	 private String sEcho;
	 private String[][] aaData;

	 public DataTableReturnObject(long totalRecords, long totalDisplayRecords,String echo, String[][] d) {
		 this.iTotalRecords = totalRecords;
		 this.iTotalDisplayRecords = totalDisplayRecords;
		 this.sEcho = echo;
		 this.aaData = d;
	 }

	 public long getiTotalRecords() {
		 return iTotalRecords;
	 }

	 public void setiTotalRecords(long iTotalRecords) {
		 this.iTotalRecords = iTotalRecords;
	 }
	 
	 public long getiTotalDisplayRecords() {
		 return iTotalDisplayRecords;
	 }

	 public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
		 this.iTotalDisplayRecords = iTotalDisplayRecords;
	 }
	 
	 public String getsEcho() {
		 return sEcho;
	 }

	 public void setsEcho(String sEcho) {
		 this.sEcho = sEcho;
	 }

	 public String[][] getAaData() {
		 return aaData;
	 }

	 public void setAaData(String[][] aaData) {
		 this.aaData = aaData;
	 }
	 
	 public String toJson(){
		 String re = "";
		 if(this.aaData.length==0){
			 re+="{\"sEcho\":"+this.sEcho+",\"iTotalRecords\":"+this.iTotalRecords+",\"iTotalDisplayRecords\":"+this.iTotalDisplayRecords+",\"aaData\":[]}";
		 }else{
			 re+="{\"sEcho\":"+this.sEcho+",\"iTotalRecords\":"+this.iTotalRecords+",\"iTotalDisplayRecords\":"+this.iTotalDisplayRecords+",\"aaData\":[";
			 for(int i=0;i<this.aaData.length;i++){
				 re+="[";
				 int j=0;
				 for(j=0;j<this.aaData[0].length-1;j++){
					 re+="\""+this.aaData[i][j]+"\",";
				 }
				 re+="\""+this.aaData[i][j]+"\"],";
			 }
			 re=re.substring(0,re.length()-1)+"]}";
		 } 
		 System.out.println(re);
		 return re;
	 }
}