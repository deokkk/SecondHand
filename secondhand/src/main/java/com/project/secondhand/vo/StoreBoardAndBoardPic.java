package com.project.secondhand.vo;

import org.springframework.web.multipart.MultipartFile;

public class StoreBoardAndBoardPic {
	private int boardNo;
	private int storeNo;
	private String categoryName;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
   private MultipartFile boardPicNameOne;
   private MultipartFile boardPicNameTwo;
   private MultipartFile boardPicNameThree;
   private MultipartFile boardPicNameFour;
   private MultipartFile boardPicNameFive;
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
public MultipartFile getBoardPicNameOne() {
	return boardPicNameOne;
}
public void setBoardPicNameOne(MultipartFile boardPicNameOne) {
	this.boardPicNameOne = boardPicNameOne;
}
public MultipartFile getBoardPicNameTwo() {
	return boardPicNameTwo;
}
public void setBoardPicNameTwo(MultipartFile boardPicNameTwo) {
	this.boardPicNameTwo = boardPicNameTwo;
}
public MultipartFile getBoardPicNameThree() {
	return boardPicNameThree;
}
public void setBoardPicNameThree(MultipartFile boardPicNameThree) {
	this.boardPicNameThree = boardPicNameThree;
}
public MultipartFile getBoardPicNameFour() {
	return boardPicNameFour;
}
public void setBoardPicNameFour(MultipartFile boardPicNameFour) {
	this.boardPicNameFour = boardPicNameFour;
}
public MultipartFile getBoardPicNameFive() {
	return boardPicNameFive;
}
public void setBoardPicNameFive(MultipartFile boardPicNameFive) {
	this.boardPicNameFive = boardPicNameFive;
}
@Override
public String toString() {
	return "StoreBoardAndBoardPic [boardNo=" + boardNo + ", storeNo=" + storeNo + ", categoryName=" + categoryName
			+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
			+ ", boardPicNameOne=" + boardPicNameOne + ", boardPicNameTwo=" + boardPicNameTwo + ", boardPicNameThree="
			+ boardPicNameThree + ", boardPicNameFour=" + boardPicNameFour + ", boardPicNameFive=" + boardPicNameFive
			+ "]";
}


	
	
}
