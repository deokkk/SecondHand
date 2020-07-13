package com.project.secondhand.vo;

public class StoreAndReportCnt {
	private Integer storeNo;
	private String storeName;
	private String storeAddr;
	private String storePhone;
	private String storeEmail;
	private String storePw;
	private String storeDate;
	private int storeReportCnt;
	public Integer getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(Integer storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreAddr() {
		return storeAddr;
	}
	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getStoreEmail() {
		return storeEmail;
	}
	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}
	public String getStorePw() {
		return storePw;
	}
	public void setStorePw(String storePw) {
		this.storePw = storePw;
	}
	public String getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(String storeDate) {
		this.storeDate = storeDate;
	}
	public int getStoreReportCnt() {
		return storeReportCnt;
	}
	public void setStoreReportCnt(int storeReportCnt) {
		this.storeReportCnt = storeReportCnt;
	}
	@Override
	public String toString() {
		return "StoreAndReportCnt [storeNo=" + storeNo + ", storeName=" + storeName + ", storeAddr=" + storeAddr
				+ ", storePhone=" + storePhone + ", storeEmail=" + storeEmail + ", storePw=" + storePw + ", storeDate="
				+ storeDate + ", storeReportCnt=" + storeReportCnt + "]";
	}
}
