package com.project.secondhand.vo;

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
	@Override
	public String toString() {
		return "StoreBoardAndBoardPic [boardNo=" + boardNo + ", storeNo=" + storeNo + ", categoryName=" + categoryName
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", boardDate=" + boardDate
				+ ", boardPicName=" + boardPicName + ", boardSize=" + boardSize + ", boardExt=" + boardExt + "]";
	}
	
}
