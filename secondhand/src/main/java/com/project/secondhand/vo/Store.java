package com.project.secondhand.vo;

public class Store {
	private int storeNo;
	private String storeName;
	private String storeAddr;
	private String storePhone;
	private String storeEmail;
	private int storePw;
	private String storeDate;
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
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
	public int getStorePw() {
		return storePw;
	}
	public void setStorePw(int storePw) {
		this.storePw = storePw;
	}
	public String getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(String storeDate) {
		this.storeDate = storeDate;
	}
	@Override
	public String toString() {
		return "Store [storeNo=" + storeNo + ", storeName=" + storeName + ", storeAddr=" + storeAddr + ", storePhone="
				+ storePhone + ", storeEmail=" + storeEmail + ", storePw=" + storePw + ", storeDate=" + storeDate + "]";
	}
	
}
