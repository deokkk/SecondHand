package com.project.secondhand.vo;

public class ItemSellReviewResult {
	private int itemNo;
	private String memberSell;
	private int memberBuy;
	private int reviewSellGrade;
	private String reviewSellContent;
	private String reviewDate;
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getMemberSell() {
		return memberSell;
	}
	public void setMemberSell(String memberSell) {
		this.memberSell = memberSell;
	}
	public int getMemberBuy() {
		return memberBuy;
	}
	public void setMemberBuy(int memberBuy) {
		this.memberBuy = memberBuy;
	}
	public int getReviewSellGrade() {
		return reviewSellGrade;
	}
	public void setReviewSellGrade(int reviewSellGrade) {
		this.reviewSellGrade = reviewSellGrade;
	}
	public String getReviewSellContent() {
		return reviewSellContent;
	}
	public void setReviewSellContent(String reviewSellContent) {
		this.reviewSellContent = reviewSellContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public String toString() {
		return "ItemSellReviewResult [itemNo=" + itemNo + ", memberSell=" + memberSell + ", memberBuy=" + memberBuy
				+ ", reviewSellGrade=" + reviewSellGrade + ", reviewSellContent=" + reviewSellContent + ", reviewDate="
				+ reviewDate + "]";
	}
	
	

}
