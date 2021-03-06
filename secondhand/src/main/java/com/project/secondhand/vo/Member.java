package com.project.secondhand.vo;

public class Member {
	private int memberNo;
	private String memberNickname;
	private String memberPw;
	private String memberPhone;
	private String memberEmail;
	private String memberDate;
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
	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberNickname=" + memberNickname + ", memberPw=" + memberPw
				+ ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberDate=" + memberDate + "]";
	}
	
}
