package com.project.secondhand.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
import com.project.secondhand.vo.MemberAddr;
import com.project.secondhand.vo.MemberInfo;
import com.project.secondhand.vo.MemberPic;
@Mapper
public interface MemberMapper {
	//회원가입
	public int addMember(Member member);
	//로그인
	public LoginMember selectLoginMember(LoginMember loginMember);
	//사진 추가
	public void addMemberPic(MemberPic memberPic);
	//주소추가
	public void addMemberAddr(MemberAddr memberAddr);
	//회원 정보 보기
	public MemberInfo selectMemberOne(LoginMember loginMember);
}
 	