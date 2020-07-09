package com.project.secondhand.vo;

public class BoardReport {
	private int boardReportNo;
	private int boardNo;
	private String boardTitle;
	private String boardStoreName; // 홍보글 등록한 업체 닉네임
	private int memberNo;
	private String memberNickName; // 신고한 멤버 닉네임
	private String categoryName;
	private String boardReportContent;
	private String boardReportDate;
	private String boardReportResultDate;
	public int getBoardReportNo() {
		return boardReportNo;
	}
	public void setBoardReportNo(int boardReportNo) {
		this.boardReportNo = boardReportNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardStoreName() {
		return boardStoreName;
	}
	public void setBoardStoreName(String boardStoreName) {
		this.boardStoreName = boardStoreName;
	}
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getBoardReportContent() {
		return boardReportContent;
	}
	public void setBoardReportContent(String boardReportContent) {
		this.boardReportContent = boardReportContent;
	}
	public String getBoardReportDate() {
		return boardReportDate;
	}
	public void setBoardReportDate(String boardReportDate) {
		this.boardReportDate = boardReportDate;
	}
	public String getBoardReportResultDate() {
		return boardReportResultDate;
	}
	public void setBoardReportResultDate(String boardReportResultDate) {
		this.boardReportResultDate = boardReportResultDate;
	}
	@Override
	public String toString() {
		return "BoardReport [boardReportNo=" + boardReportNo + ", boardNo=" + boardNo + ", boardTitle=" + boardTitle
				+ ", boardStoreName=" + boardStoreName + ", memberNo=" + memberNo + ", memberNickName=" + memberNickName
				+ ", categoryName=" + categoryName + ", boardReportContent=" + boardReportContent + ", boardReportDate="
				+ boardReportDate + ", boardReportResultDate=" + boardReportResultDate + "]";
	}
}
