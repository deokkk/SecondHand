package com.project.secondhand.vo;

public class ItemReportResult {
	private int itemReportResultNo;
	private int itemNo;
	private int memberNo;
	private String  categoryName;
	private String itemReportResultContent;
	private String itemReportResultDate;
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
	@Override
	public String toString() {
		return "ItemReportResult [itemReportResultNo=" + itemReportResultNo + ", itemNo=" + itemNo + ", memberNo="
				+ memberNo + ", categoryName=" + categoryName + ", itemReportResultContent=" + itemReportResultContent
				+ ", itemReportResultDate=" + itemReportResultDate + "]";
	}
	
	
}
