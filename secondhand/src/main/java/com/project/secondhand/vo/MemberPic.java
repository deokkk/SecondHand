package com.project.secondhand.vo;

public class MemberPic {
	private int memberNo;
	private String memberPicName;
	private int memberPicSize;
	private int memberPicExt;
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
	public int getMemberPicSize() {
		return memberPicSize;
	}
	public void setMemberPicSize(int memberPicSize) {
		this.memberPicSize = memberPicSize;
	}
	public int getMemberPicExt() {
		return memberPicExt;
	}
	public void setMemberPicExt(int memberPicExt) {
		this.memberPicExt = memberPicExt;
	}
	@Override
	public String toString() {
		return "MemberPic [memberNo=" + memberNo + ", memberPicName=" + memberPicName + ", memberPicSize="
				+ memberPicSize + ", memberPicExt=" + memberPicExt + "]";
	}
	
}
