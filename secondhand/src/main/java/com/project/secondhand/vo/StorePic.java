package com.project.secondhand.vo;

public class StorePic {
	private int stroreNo;
	private String storePicName;
	private String storePicSize;
	private String storePicExt;
	public int getStroreNo() {
		return stroreNo;
	}
	public void setStroreNo(int stroreNo) {
		this.stroreNo = stroreNo;
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
		return "StorePic [stroreNo=" + stroreNo + ", storePicName=" + storePicName + ", storePicSize=" + storePicSize
				+ ", storePicExt=" + storePicExt + "]";
	}
	
	
}
