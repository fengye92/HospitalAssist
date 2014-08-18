package com.iel.hos.beans;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {

    // 分页静态不变属性
    public static final String SIZE = "size";   //每页显示的记录数
    public static final String CURPAGE = "curPage";   //总页数
    public static final String STARTPAGE = "startPage"; //新一页的起始页 
    private long total;
	private List<T> data = new ArrayList<T>();

    public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

    @Override
    public String toString() {
       return "PageUtil [data=" + data + ", total=" + total + "]";
    }
}
