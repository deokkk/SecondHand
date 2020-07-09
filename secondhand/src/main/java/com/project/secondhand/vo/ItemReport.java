package com.project.secondhand.vo;

public class ItemReport {
	private int itemReportNo;
	private int itemNo;
	private String itemTitle;
	private String itemMemberNickName; // 상품 등록한 멤버 닉네임
	private int memberNo;
	private String memberNickName; // 신고한 멤버 닉네임
	private String categoryName;
	private String itemReportContent;
	private String itemReportDate;
	private String itemReportResultDate;
	public int getItemReportNo() {
		return itemReportNo;
	}
	public void setItemReportNo(int itemReportNo) {
		this.itemReportNo = itemReportNo;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemMemberNickName() {
		return itemMemberNickName;
	}
	public void setItemMemberNickName(String itemMemberNickName) {
		this.itemMemberNickName = itemMemberNickName;
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
	public String getItemReportContent() {
		return itemReportContent;
	}
	public void setItemReportContent(String itemReportContent) {
		this.itemReportContent = itemReportContent;
	}
	public String getItemReportDate() {
		return itemReportDate;
	}
	public void setItemReportDate(String itemReportDate) {
		this.itemReportDate = itemReportDate;
	}
	public String getItemReportResultDate() {
		return itemReportResultDate;
	}
	public void setItemReportResultDate(String itemReportResultDate) {
		this.itemReportResultDate = itemReportResultDate;
	}
	@Override
	public String toString() {
		return "ItemReport [itemReportNo=" + itemReportNo + ", itemNo=" + itemNo + ", itemTitle=" + itemTitle
				+ ", itemMemberNickName=" + itemMemberNickName + ", memberNo=" + memberNo + ", memberNickName="
				+ memberNickName + ", categoryName=" + categoryName + ", itemReportContent=" + itemReportContent
				+ ", itemReportDate=" + itemReportDate + ", itemReportResultDate=" + itemReportResultDate + "]";
	}
}