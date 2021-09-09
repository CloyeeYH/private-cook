package com.hpe.util;

import java.util.ArrayList;
import java.util.List;

/*
 * 分页实体类
 */
public class Page {

	//每页显示的条数
	private int pageNumber=5;
	//当前页
	private int curPage;
	//总条数
	private int rows;
	//总页数
	private int totalPage;
	//要现实的list
	private List list=new ArrayList();
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [pageNumber=" + pageNumber + ", curPage=" + curPage + ", rows=" + rows + ", totalPage=" + totalPage
				+ ", list=" + list + "]";
	}
	
}
