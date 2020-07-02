package com.project.secondhand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.secondhand.mapper.MemberMapper;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
@Service
@Transactional
public class MemberService {
	@Autowired
	
	private MemberMapper memberMapper;
	//회원가입
	public int addMember(Member member) {
		return memberMapper.addMember(member);
	}
	//로그인
	public Member login(LoginMember loginMember) {
		return memberMapper.selectLoginMember(loginMember);
	}
	
}
