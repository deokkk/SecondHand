package com.project.secondhand.vo;

import org.springframework.web.multipart.MultipartFile;

public class StoreBoardAndBoardPic {
	private int boardNo;
	private int storeNo;
	private String categoryName;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private String boardPicName;
	private String boardSize;
	private String boardExt;
   private MultipartFile itemPicNameOne;
   private MultipartFile itemPicNameTwo;
   private MultipartFile itemPicNameThree;
   private MultipartFile itemPicNameFour;
   private MultipartFile itemPicNameFive;
public int getBoardNo() {
	return boardNo;
}
public void setBoardNo(int boardNo) {
	this.boardNo = boardNo;
}
public int getStoreNo() {
	return storeNo;
}
public void setStoreNo(int storeNo) {
	this.storeNo = storeNo;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getBoardTitle() {
	return boardTitle;
}
public void setBoardTitle(String boardTitle) {
	this.boardTitle = boardTitle;
}
public String getBoardContent() {
	return boardContent;
}
public void setBoardContent(String boardContent) {
	this.boardContent = boardContent;
}
public String getBoardDate() {
	return boardDate;
}
public void setBoardDate(String boardDate) {
	this.boardDate = boardDate;
}
public String getBoardPicName() {
	return boardPicName;
}
public void setBoardPicName(String boardPicName) {
	this.boardPicName = boardPicName;
}
public String getBoardSize() {
	return boardSize;
}
public void setBoardSize(String boardSize) {
	this.boardSize = boardSize;
}
public String getBoardExt() {
	return boardExt;
}
public void setBoardExt(String boardExt) {
	this.boardExt = boardExt;
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
	return "StoreBoardAndBoardPic [boardNo=" + boardNo + ", storeNo=" + storeNo + ", categoryName=" + categoryName
			+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
			+ ", boardPicName=" + boardPicName + ", boardSize=" + boardSize + ", boardExt=" + boardExt
			+ ", itemPicNameOne=" + itemPicNameOne + ", itemPicNameTwo=" + itemPicNameTwo + ", itemPicNameThree="
			+ itemPicNameThree + ", itemPicNameFour=" + itemPicNameFour + ", itemPicNameFive=" + itemPicNameFive + "]";
}

	
	
}
