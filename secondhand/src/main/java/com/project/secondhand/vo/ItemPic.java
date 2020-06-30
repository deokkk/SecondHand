package com.project.secondhand.vo;

public class ItemPic {
	private int itemNo;
	private String itemPicName;
	private String itemPicSize;
	private String itemPicExt;
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemPicName() {
		return itemPicName;
	}
	public void setItemPicName(String itemPicName) {
		this.itemPicName = itemPicName;
	}
	public String getItemPicSize() {
		return itemPicSize;
	}
	public void setItemPicSize(String itemPicSize) {
		this.itemPicSize = itemPicSize;
	}
	public String getItemPicExt() {
		return itemPicExt;
	}
	public void setItemPicExt(String itemPicExt) {
		this.itemPicExt = itemPicExt;
	}
	@Override
	public String toString() {
		return "ItemPic [itemNo=" + itemNo + ", itemPicName=" + itemPicName + ", itemPicSize=" + itemPicSize
				+ ", itemPicExt=" + itemPicExt + "]";
	}
	
}
