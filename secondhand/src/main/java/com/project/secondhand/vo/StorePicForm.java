package com.project.secondhand.vo;

import org.springframework.web.multipart.MultipartFile;

public class StorePicForm {
	private int stroreNo;
	private MultipartFile storePicName;
	private String storePicSize;
	private String storePicExt;
	public int getStroreNo() {
		return stroreNo;
	}
	public void setStroreNo(int stroreNo) {
		this.stroreNo = stroreNo;
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
		return "StorePicForm [stroreNo=" + stroreNo + ", storePicName=" + storePicName + ", storePicSize="
				+ storePicSize + ", storePicExt=" + storePicExt + "]";
	}
}
