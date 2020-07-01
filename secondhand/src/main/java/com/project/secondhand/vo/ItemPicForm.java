package com.project.secondhand.vo;

import org.springframework.web.multipart.MultipartFile;

public class ItemPicForm {
	private int itemNo;
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
		return "ItemPicForm [itemNo=" + itemNo + ", itemPicNameOne=" + itemPicNameOne + ", itemPicNameTwo="
				+ itemPicNameTwo + ", itemPicNameThree=" + itemPicNameThree + ", itemPicNameFour=" + itemPicNameFour
				+ ", itemPicNameFive=" + itemPicNameFive + "]";
	}
	
}
