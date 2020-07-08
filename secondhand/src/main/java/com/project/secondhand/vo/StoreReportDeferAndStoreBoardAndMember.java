package com.project.secondhand.vo;

public class StoreReportDeferAndStoreBoardAndMember {
	private int boardReportDeferNo;
	private int boardNo;
	private int memberNo;
	private String categoryName;
	private String boardReportDeferContent;
	private String boardReportDeferDate;
	private String boardTitle;
	private String boardContent;
	private String memberNickname;
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
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	@Override
	public String toString() {
		return "StoreReportDeferAndStoreBoardAndMember [boardReportDeferNo=" + boardReportDeferNo + ", boardNo="
				+ boardNo + ", memberNo=" + memberNo + ", categoryName=" + categoryName + ", boardReportDeferContent="
				+ boardReportDeferContent + ", boardReportDeferDate=" + boardReportDeferDate + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", memberNickname=" + memberNickname + "]";
	}
	

}
