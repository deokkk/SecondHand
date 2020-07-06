package com.project.secondhand.vo;

public class MemberPic {
	private int memberNo;
	private String memberPicName;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getMemberPicName() {
		return memberPicName;
	}
	public void setMemberPicName(String memberPicName) {
		this.memberPicName = memberPicName;
	}
	@Override
	public String toString() {
		return "MemberPic [memberNo=" + memberNo + ", memberPicName=" + memberPicName + "]";
	}
}
