package com.project.secondhand.vo;

public class ItemReportDeferAndItemAndMember {
	private int itemReportDeferNo;
	private int itemNo;
	private int memberNo;
	private String categoryName;
	private String itemReportDeferContent;
	private String itemReportDeferDate;
	private String itemTitle;
	private String itemContent;
	private String memberNickname;
	public int getItemReportDeferNo() {
		return itemReportDeferNo;
	}
	public void setItemReportDeferNo(int itemReportDeferNo) {
		this.itemReportDeferNo = itemReportDeferNo;
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
	public String getItemReportDeferContent() {
		return itemReportDeferContent;
	}
	public void setItemReportDeferContent(String itemReportDeferContent) {
		this.itemReportDeferContent = itemReportDeferContent;
	}
	public String getItemReportDeferDate() {
		return itemReportDeferDate;
	}
	public void setItemReportDeferDate(String itemReportDeferDate) {
		this.itemReportDeferDate = itemReportDeferDate;
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
		return "ItemReportDeferAndItemAndMember [itemReportDeferNo=" + itemReportDeferNo + ", itemNo=" + itemNo
				+ ", memberNo=" + memberNo + ", categoryName=" + categoryName + ", itemReportDeferContent="
				+ itemReportDeferContent + ", itemReportDeferDate=" + itemReportDeferDate + ", itemTitle=" + itemTitle
				+ ", itemContent=" + itemContent + ", memberNickname=" + memberNickname + "]";
	}

	
}
