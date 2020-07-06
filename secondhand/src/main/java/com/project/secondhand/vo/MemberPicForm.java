package com.project.secondhand.vo;

import org.springframework.web.multipart.MultipartFile;

public class MemberPicForm {
	private int memberNo;
	private MultipartFile memberPicName;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public MultipartFile getMemberPicName() {
		return memberPicName;
	}
	public void setMemberPicName(MultipartFile memberPicName) {
		this.memberPicName = memberPicName;
	}
	@Override
	public String toString() {
		return "MemberPicForm [memberNo=" + memberNo + ", memberPicName=" + memberPicName + "]";
	}
}
