package com.project.secondhand.vo;

import org.springframework.web.multipart.MultipartFile;

public class ItemAndItemPic {
	private int itemNo;
	private String categoryName;
	private int memberNo;
	private String itemTitle;
	private String itemContent;
	private int itemPrice;
	private String itemState;
	private String itemDate;
	private MultipartFile itemPicNameOne;
	private MultipartFile itemPicNameTwo;
	private MultipartFile itemPicNameThree;
	private MultipartFile itemPicNameFour;
	private MultipartFile itemPicNameFive;
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
	public MultipartFile getItemPicNameOne() {
		return itemPicNameOne;
	}
	public void setItemPicNameOne(MultipartFile itemPicNameOne) {
		this.itemPicNameOne = itemPicNameOne;
	}
	public MultipartFile getItemPicNameTwo() {
		return itemPicNameTwo;
	}
	public void setItemPicNameTwo(MultipartFile itemPicNameTwo) {
		this.itemPicNameTwo = itemPicNameTwo;
	}
	public MultipartFile getItemPicNameThree() {
		return itemPicNameThree;
	}
	public void setItemPicNameThree(MultipartFile itemPicNameThree) {
		this.itemPicNameThree = itemPicNameThree;
	}
	public MultipartFile getItemPicNameFour() {
		return itemPicNameFour;
	}
	public void setItemPicNameFour(MultipartFile itemPicNameFour) {
		this.itemPicNameFour = itemPicNameFour;
	}
	public MultipartFile getItemPicNameFive() {
		return itemPicNameFive;
	}
	public void setItemPicNameFive(MultipartFile itemPicNameFive) {
		this.itemPicNameFive = itemPicNameFive;
	}
	@Override
	public String toString() {
		return "ItemAndItemPic [itemNo=" + itemNo + ", categoryName=" + categoryName + ", memberNo=" + memberNo
				+ ", itemTitle=" + itemTitle + ", itemContent=" + itemContent + ", itemPrice=" + itemPrice
				+ ", itemState=" + itemState + ", itemDate=" + itemDate + ", itemPicNameOne=" + itemPicNameOne
				+ ", itemPicNameTwo=" + itemPicNameTwo + ", itemPicNameThree=" + itemPicNameThree + ", itemPicNameFour="
				+ itemPicNameFour + ", itemPicNameFive=" + itemPicNameFive + "]";
	}
	

}
