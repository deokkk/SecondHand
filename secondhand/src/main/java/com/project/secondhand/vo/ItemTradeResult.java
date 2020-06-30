package com.project.secondhand.vo;

public class ItemTradeResult {
	private int itemNo;
	private String tradeTo;
	private int tradeFrom;
	private int reviewGrade;
	private String reviewContent;
	private String reviewDate;
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getTradeTo() {
		return tradeTo;
	}
	public void setTradeTo(String tradeTo) {
		this.tradeTo = tradeTo;
	}
	public int getTradeFrom() {
		return tradeFrom;
	}
	public void setTradeFrom(int tradeFrom) {
		this.tradeFrom = tradeFrom;
	}
	public int getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(int reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public String toString() {
		return "ItemTradeResult [itemNo=" + itemNo + ", tradeTo=" + tradeTo + ", tradeFrom=" + tradeFrom
				+ ", reviewGrade=" + reviewGrade + ", reviewContent=" + reviewContent + ", reviewDate=" + reviewDate
				+ "]";
	}
	
}
