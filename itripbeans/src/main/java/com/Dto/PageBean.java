package com.Dto;

import java.util.List;

import org.springframework.stereotype.Component;
public class PageBean<T> {
	private int currPageNo;        //当前页码
	private int pageSize;         //页面大小
	private int totalCount;       //记录总数
	private int totalPageCount;  //总页数
	private List<T> list;
	
	private String queryProCode;
	private String queryProName;
	
	private String productName;
	private int providerId;
	private int isPayment;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public int getIsPayment() {
		return isPayment;
	}
	public void setIsPayment(int isPayment) {
		this.isPayment = isPayment;
	}
	private String userName;
	private int userRole;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserRole() {
		return userRole;
	}
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
	public String getQueryProCode() {
		return queryProCode;
	}
	public void setQueryProCode(String queryProCode) {
		this.queryProCode = queryProCode;
	}
	public String getQueryProName() {
		return queryProName;
	}
	public void setQueryProName(String queryProName) {
		this.queryProName = queryProName;
	}
	public int getCurrPageNo() {
		return currPageNo;
	}
	public void setCurrPageNo(int currPageNo) {
		if(currPageNo>0){
			this.currPageNo = currPageNo;
		}
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize>0){
			this.pageSize = pageSize;
		}
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
			this.totalCount = totalCount;
			this.totalPageCount=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:(this.totalCount/this.pageSize)+1;
		}
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
