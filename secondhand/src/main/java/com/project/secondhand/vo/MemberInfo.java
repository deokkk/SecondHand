package com.project.secondhand.vo;

public class MemberInfo {
	private int memberNo;
	private String memberNickname;
	private String memberPw;
	private String memberPhone;
	private String memberEmail;
	private String memberDate;
	private String memberPicName;
	private String bigCity;
	private String middleCity;
	private String smallCity;
	private int itemNo;
	private int temperNo;
	private float temper;
	private float temperTotal;
	private String temperDate;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberNickname() {
		return memberNickname;
	}
	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberDate() {
		return memberDate;
	}
	public void setMemberDate(String memberDate) {
		this.memberDate = memberDate;
	}
	public String getMemberPicName() {
		return memberPicName;
	}
	public void setMemberPicName(String memberPicName) {
		this.memberPicName = memberPicName;
	}
	public String getBigCity() {
		return bigCity;
	}
	public void setBigCity(String bigCity) {
		this.bigCity = bigCity;
	}
	public String getMiddleCity() {
		return middleCity;
	}
	public void setMiddleCity(String middleCity) {
		this.middleCity = middleCity;
	}
	public String getSmallCity() {
		return smallCity;
	}
	public void setSmallCity(String smallCity) {
		this.smallCity = smallCity;
	}
	@Override
	public String toString() {
		return "MemberInfo [memberNo=" + memberNo + ", memberNickname=" + memberNickname + ", memberPw=" + memberPw
				+ ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberDate=" + memberDate
				+ ", memberPicName=" + memberPicName + ", bigCity=" + bigCity + ", middleCity=" + middleCity
				+ ", smallCity=" + smallCity + ", itemNo=" + itemNo + ", temperNo=" + temperNo + ", temper=" + temper
				+ ", temperTotal=" + temperTotal + ", temperDate=" + temperDate + "]";
	}
	public int getItemNo() {
		return itemNo;
	}
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	public int getTemperNo() {
		return temperNo;
	}
	public void setTemperNo(int temperNo) {
		this.temperNo = temperNo;
	}
	public float getTemper() {
		return temper;
	}
	public void setTemper(float temper) {
		this.temper = temper;
	}
	public float getTemperTotal() {
		return temperTotal;
	}
	public void setTemperTotal(float temperTotal) {
		this.temperTotal = temperTotal;
	}
	public String getTemperDate() {
		return temperDate;
	}
	public void setTemperDate(String temperDate) {
		this.temperDate = temperDate;
	}
}
