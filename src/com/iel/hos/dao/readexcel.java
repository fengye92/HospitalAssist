package com.iel.hos.dao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jboss.netty.handler.codec.http.HttpRequest;

import net.sf.json.JSONArray;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class readexcel {
	public String read()//src为excel文件所在路径
	{
		JSONArray array = new JSONArray();
		File file=new File("d://aa.xlsx");
		try {
			Workbook wb=Workbook.getWorkbook(file);
			Sheet sheet = wb.getSheet(0);
			for(int i=0;i<sheet.getRows();i++)
			{
				List<String> list = new ArrayList<String>();
				String tmp = null;
				for(int j=0;j<sheet.getColumns();j++)
				{
					Cell cell=sheet.getCell(j,i);
					list.add(cell.toString());
				}
				array.add(list);
			}
			HttpServletRequest request=(HttpServletRequest) ServletActionContext.getRequest();
			request.setAttribute("array", array);
			return "success";
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
		
	}
}
