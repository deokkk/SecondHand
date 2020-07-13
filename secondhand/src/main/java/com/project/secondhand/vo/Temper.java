package com.project.secondhand.vo;

public class Temper {
	private int temperNo;
	private int itemNo;
	private int memberNo;
	private int temper;
	private int temperTotal;
	private String temperDate;
	public int getTemperNo() {
		return temperNo;
	}
	public void setTemperNo(int temperNo) {
		this.temperNo = temperNo;
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
	public int getTemper() {
		return temper;
	}
	public void setTemper(int temper) {
		this.temper = temper;
	}
	public int getTemperTotal() {
		return temperTotal;
	}
	public void setTemperTotal(int temperTotal) {
		this.temperTotal = temperTotal;
	}
	public String getTemperDate() {
		return temperDate;
	}
	public void setTemperDate(String temperDate) {
		this.temperDate = temperDate;
	}
	@Override
	public String toString() {
		return "Temper [temperNo=" + temperNo + ", itemNo=" + itemNo + ", memberNo=" + memberNo + ", temper=" + temper
				+ ", temperTotal=" + temperTotal + ", temperDate=" + temperDate + "]";
	}
}
