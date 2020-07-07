package com.project.secondhand.vo;

import org.springframework.web.multipart.MultipartFile;

public class ItemAndMemberAndMemberAddrAndItemPic {
	private int memberNo; //market_member
	private String memberNickName;
	private String bigCity;
	private String middleCity;
	private String smallCity;
	private int itemNo;
	private String categoryName;
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
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberNickName() {
		return memberNickName;
	}
	public void setMemberNickName(String memberNickName) {
		this.memberNickName = memberNickName;
	}
	public String getBigCity() {
		return bigCity;
	}
	public void setBigCity(String bigCity) {
		this.bigCity = bigCity;
	}
	public String getMiddleCity() {
		return middleCity;
	}
	public void setMiddleCity(String middleCity) {
		this.middleCity = middleCity;
	}
	public String getSmallCity() {
		return smallCity;
	}
	public void setSmallCity(String smallCity) {
		this.smallCity = smallCity;
	}
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
		return "ItemAndMemberAndMemberAddrAndItemPic [memberNo=" + memberNo + ", memberNickName=" + memberNickName
				+ ", bigCity=" + bigCity + ", middleCity=" + middleCity + ", smallCity=" + smallCity + ", itemNo="
				+ itemNo + ", categoryName=" + categoryName + ", itemTitle=" + itemTitle + ", itemContent="
				+ itemContent + ", itemPrice=" + itemPrice + ", itemState=" + itemState + ", itemDate=" + itemDate
				+ ", itemPicNameOne=" + itemPicNameOne + ", itemPicNameTwo=" + itemPicNameTwo + ", itemPicNameThree="
				+ itemPicNameThree + ", itemPicNameFour=" + itemPicNameFour + ", itemPicNameFive=" + itemPicNameFive
				+ "]";
	}
	

}
