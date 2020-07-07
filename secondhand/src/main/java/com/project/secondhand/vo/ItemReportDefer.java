package com.project.secondhand.vo;

public class ItemReportDefer {
	private int itemReportDeferNo;
	private int itemNo;
	private int memberNo;
	private String categoryName;
	private String itemReportDeferContent;
	private String itemReportDeferDate;
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
	@Override
	public String toString() {
		return "ItemReportDefer [itemReportDeferNo=" + itemReportDeferNo + ", itemNo=" + itemNo + ", memberNo="
				+ memberNo + ", categoryName=" + categoryName + ", itemReportDeferContent=" + itemReportDeferContent
				+ ", itemReportDeferDate=" + itemReportDeferDate + "]";
	}
	
}
