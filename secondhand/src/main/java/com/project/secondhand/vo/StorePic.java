package com.project.secondhand.vo;

public class StorePic {
	private int storeNo;
	private String storePicNameOne;
	private String storePicNameTwo;
	private String storePicNameThree;
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
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
		return "StorePic [storeNo=" + storeNo + ", storePicNameOne=" + storePicNameOne + ", storePicNameTwo="
				+ storePicNameTwo + ", storePicNameThree=" + storePicNameThree + "]";
	}


}

	
