package com.project.secondhand.vo;

import org.springframework.web.multipart.MultipartFile;

public class StorePicForm {
	private int storeNo;
	private MultipartFile storePicName;
	private String storePicSize;
	private String storePicExt;
	public int getStroreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public MultipartFile getStorePicName() {
		return storePicName;
	}
	public void setStorePicName(MultipartFile storePicName) {
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
		return "StorePicForm [storeNo=" + storeNo + ", storePicName=" + storePicName + ", storePicSize="
				+ storePicSize + ", storePicExt=" + storePicExt + "]";
	}
}
