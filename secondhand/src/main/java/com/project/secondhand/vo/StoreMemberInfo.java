package com.project.secondhand.vo;

public class StoreMemberInfo {
	private Integer storeNo;
	private String storeName;
	private String storeAddr;
	private String storePhone;
	private String storeEmail;
	private String storePw;
	private String storeDate;
	private String storePicNameOne;
	private String storePicNameTwo;
	private String storePicNameThree;
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
	public String getStorePicNameOne() {
		return storePicNameOne;
	}
	public void setStorePicNameOne(String storePicNameOne) {
		this.storePicNameOne = storePicNameOne;
	}
	public String getStorePicNameTwo() {
		return storePicNameTwo;
	}
	public void setStorePicNameTwo(String storePicNameTwo) {
		this.storePicNameTwo = storePicNameTwo;
	}
	public String getStorePicNameThree() {
		return storePicNameThree;
	}
	public void setStorePicNameThree(String storePicNameThree) {
		this.storePicNameThree = storePicNameThree;
	}
	@Override
	public String toString() {
		return "StoreInfo [storeNo=" + storeNo + ", storeName=" + storeName + ", storeAddr=" + storeAddr
				+ ", storePhone=" + storePhone + ", storeEmail=" + storeEmail + ", storePw=" + storePw + ", storeDate="
				+ storeDate + ", storePicNameOne=" + storePicNameOne + ", storePicNameTwo=" + storePicNameTwo
				+ ", storePicNameThree=" + storePicNameThree + "]";
	}
}
