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
				+ ", smallCity=" + smallCity + "]";
	}
}
