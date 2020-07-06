package com.project.secondhand.vo;

public class LoginMember {
	private String memberEmail;
	private String memberPw;
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	@Override
	public String toString() {
		return "LoginMember [memberEmail=" + memberEmail + ", memberPw=" + memberPw + "]";
	}
	

}
