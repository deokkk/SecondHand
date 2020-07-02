package com.project.secondhand.vo;

public class StorePic {
	private int storeNo;
	private String storePicName;
	private String storePicSize;
	private String storePicExt;
	public int getStroreNo() {
		return storeNo;
	}
	public void setStroreNo(int stroreNo) {
		this.storeNo = stroreNo;
	}
	public String getStorePicName() {
		return storePicName;
	}
	public void setStorePicName(String storePicName) {
		this.storePicName = storePicName;
	}
	public String getStorePicSize() {
		return storePicSize;
	}
	public void setStorePicSize(String storePicSize) {
		this.storePicSize = storePicSize;
	}
	public String getStorePicExt() {
		return storePicExt;
	}
	public void setStorePicExt(String storePicExt) {
		this.storePicExt = storePicExt;
	}
	@Override
	public String toString() {
		return "StorePic [storeNo=" + storeNo + ", storePicName=" + storePicName + ", storePicSize=" + storePicSize
				+ ", storePicExt=" + storePicExt + "]";
	}
	
	
}
