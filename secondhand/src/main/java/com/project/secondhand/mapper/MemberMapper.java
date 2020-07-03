package com.project.secondhand.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Admin;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
@Mapper
public interface MemberMapper {
	//회원가입
	public int addMember(Member member);
	//로그인
	public LoginMember selectLoginMember(LoginMember loginMember);
}
 	