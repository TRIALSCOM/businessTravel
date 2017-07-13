package com.businessTravel.domain;

import java.io.Serializable;

public class Pager implements Serializable {
	
	private  Integer curPage;
	private  Integer perPageRows;
	private  Integer rowCount;
	private  Integer pageCount;
	public Integer getCurPage() {
		this.curPage=curPage<=0?1:this.curPage;
		this.curPage=curPage>pageCount?pageCount:this.curPage;
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		 this.curPage = curPage;
	}
	public Integer getPerPageRows() {
		  return perPageRows;
	}
	public void setPerPageRows(Integer perPageRows) {
		  this.perPageRows = perPageRows;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getPageCount() {
		
		return (rowCount+perPageRows-1)/perPageRows;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	
	public Integer getFirstLimitCount(){
		
		return (this.getCurPage()-1)*perPageRows;
		
	}
	

}
