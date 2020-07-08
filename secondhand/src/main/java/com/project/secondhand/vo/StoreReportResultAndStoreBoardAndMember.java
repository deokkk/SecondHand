package com.project.secondhand.vo;

public class StoreReportResultAndStoreBoardAndMember {
	private int boardReportResultNo;
	private String categoryName;
	private int memberNo;
	private int boardNo;
	private String boardReportResultContent;
	private String boardReportResultDate;
	private String boardTitle;
	private String boardContent;
	private String memberNickname;
	public int getBoardReportResultNo() {
		return boardReportResultNo;
	}
	public void setBoardReportResultNo(int boardReportResultNo) {
		this.boardReportResultNo = boardReportResultNo;
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
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardReportResultContent() {
		return boardReportResultContent;
	}
	public void setBoardReportResultContent(String boardReportResultContent) {
		this.boardReportResultContent = boardReportResultContent;
	}
	public String getBoardReportResultDate() {
		return boardReportResultDate;
	}
	public void setBoardReportResultDate(String boardReportResultDate) {
		this.boardReportResultDate = boardReportResultDate;
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
		return "StoreReportResultAndStoreBoardAndMember [boardReportResultNo=" + boardReportResultNo + ", categoryName="
				+ categoryName + ", memberNo=" + memberNo + ", boardNo=" + boardNo + ", boardReportResultContent="
				+ boardReportResultContent + ", boardReportResultDate=" + boardReportResultDate + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", memberNickname=" + memberNickname + "]";
	}
	

}
