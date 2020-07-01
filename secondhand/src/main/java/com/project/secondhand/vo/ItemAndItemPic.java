package com.project.secondhand.vo;

public class ItemAndItemPic {
	private int itemNo;
	private String categoryName;
	private int memberNo;
	private String itemTitle;
	private String itemContent;
	private int itemPrice;
	private String itemState;
	private String itemDate;
	private String itemPicName;
	private String itemPicSize;
	private String itemPicExt;
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemState() {
		return itemState;
	}
	public void setItemState(String itemState) {
		this.itemState = itemState;
	}
	public String getItemDate() {
		return itemDate;
	}
	public void setItemDate(String itemDate) {
		this.itemDate = itemDate;
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
		return "ItemAndItemPic [itemNo=" + itemNo + ", categoryName=" + categoryName + ", memberNo=" + memberNo
				+ ", itemTitle=" + itemTitle + ", itemContent=" + itemContent + ", itemPrice=" + itemPrice
				+ ", itemState=" + itemState + ", itemDate=" + itemDate + ", itemPicName=" + itemPicName
				+ ", itemPicSize=" + itemPicSize + ", itemPicExt=" + itemPicExt + "]";
	}
	

}
