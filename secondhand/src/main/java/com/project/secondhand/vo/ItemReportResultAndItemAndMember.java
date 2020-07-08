package com.project.secondhand.vo;

public class ItemReportResultAndItemAndMember {
	private int itemReportResultNo;
	private int itemNo;
	private int memberNo;
	private String  categoryName;
	private String itemReportResultContent;
	private String itemReportResultDate;
	private String itemTitle;
	private String itemContent;
	private String memberNickname;
	public int getItemReportResultNo() {
		return itemReportResultNo;
	}
	public void setItemReportResultNo(int itemReportResultNo) {
		this.itemReportResultNo = itemReportResultNo;
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
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
	public String getItemReportResultContent() {
		return itemReportResultContent;
	}
	public void setItemReportResultContent(String itemReportResultContent) {
		this.itemReportResultContent = itemReportResultContent;
	}
	public String getItemReportResultDate() {
		return itemReportResultDate;
	}
	public void setItemReportResultDate(String itemReportResultDate) {
		this.itemReportResultDate = itemReportResultDate;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public String getItemContent() {
		return itemContent;
	}
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	@Override
	public String toString() {
		return "ItemReportResultAndItemAndMember [itemReportResultNo=" + itemReportResultNo + ", itemNo=" + itemNo
				+ ", memberNo=" + memberNo + ", categoryName=" + categoryName + ", itemReportResultContent="
				+ itemReportResultContent + ", itemReportResultDate=" + itemReportResultDate + ", itemTitle="
				+ itemTitle + ", itemContent=" + itemContent + ", memberNickname=" + memberNickname + "]";
	}
	
	

}
