package com.project.secondhand.vo;

public class Qna {
	private String qnaTitle;
	private int memberNo;
	private String categoryName;
	private String qnaContent;
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
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
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	@Override
	public String toString() {
		return "Qna [qnaTitle=" + qnaTitle + ", memberNo=" + memberNo + ", categoryName=" + categoryName
				+ ", qnaContent=" + qnaContent + "]";
	}
}
