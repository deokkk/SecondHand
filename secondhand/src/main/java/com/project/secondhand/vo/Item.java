package com.project.secondhand.vo;

public class Item {
	private int itemNo;
	private String categoryName;
	private int memberNo;
	private String itemTitle;
	private String itemContent;
	private int itemPrice;
	private String itemState;
	private String itemDate;
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
	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", categoryName=" + categoryName + ", memberNo=" + memberNo + ", itemTitle="
				+ itemTitle + ", itemContent=" + itemContent + ", itemPrice=" + itemPrice + ", itemState=" + itemState
				+ ", itemDate=" + itemDate + "]";
	}
	
}
