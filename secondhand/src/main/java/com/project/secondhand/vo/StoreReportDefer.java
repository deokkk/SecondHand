package com.project.secondhand.vo;

public class StoreReportDefer {
	private int boardReportDeferNo;
	private int boardNo;
	private int memberNo;
	private String categoryName;
	private String boardReportDeferContent;
	private String boardReportDeferDate;
	public int getBoardReportDeferNo() {
		return boardReportDeferNo;
	}
	public void setBoardReportDeferNo(int boardReportDeferNo) {
		this.boardReportDeferNo = boardReportDeferNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBoardReportDeferContent() {
		return boardReportDeferContent;
	}
	public void setBoardReportDeferContent(String boardReportDeferContent) {
		this.boardReportDeferContent = boardReportDeferContent;
	}
	public String getBoardReportDeferDate() {
		return boardReportDeferDate;
	}
	public void setBoardReportDeferDate(String boardReportDeferDate) {
		this.boardReportDeferDate = boardReportDeferDate;
	}
	@Override
	public String toString() {
		return "StoreReportDefer [boardReportDeferNo=" + boardReportDeferNo + ", boardNo=" + boardNo + ", memberNo="
				+ memberNo + ", categoryName=" + categoryName + ", boardReportDeferContent=" + boardReportDeferContent
				+ ", boardReportDeferDate=" + boardReportDeferDate + "]";
	}
	
	

}
