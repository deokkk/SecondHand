package com.project.secondhand.vo;

public class ItemBuyReviewResult {
	private int itemNo;
	private String memberBuy;
	private int memberSell;
	private int reviewBuyGrade;
	private String reviewBuyContent;
	private String reviewDate;
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getMemberBuy() {
		return memberBuy;
	}
	public void setMemberBuy(String memberBuy) {
		this.memberBuy = memberBuy;
	}
	public int getMemberSell() {
		return memberSell;
	}
	public void setMemberSell(int memberSell) {
		this.memberSell = memberSell;
	}
	public int getReviewBuyGrade() {
		return reviewBuyGrade;
	}
	public void setReviewBuyGrade(int reviewBuyGrade) {
		this.reviewBuyGrade = reviewBuyGrade;
	}
	public String getReviewBuyContent() {
		return reviewBuyContent;
	}
	public void setReviewBuyContent(String reviewBuyContent) {
		this.reviewBuyContent = reviewBuyContent;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	@Override
	public String toString() {
		return "ItemBuyReviewResult [itemNo=" + itemNo + ", memberBuy=" + memberBuy + ", memberSell=" + memberSell
				+ ", reviewBuyGrade=" + reviewBuyGrade + ", reviewBuyContent=" + reviewBuyContent + ", reviewDate="
				+ reviewDate + "]";
	}
	
}
