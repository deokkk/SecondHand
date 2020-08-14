package com.project.secondhand.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ItemList;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
import com.project.secondhand.vo.MemberAddr;
import com.project.secondhand.vo.MemberAndReportCnt;
import com.project.secondhand.vo.MemberInfo;
import com.project.secondhand.vo.MemberPic;
import com.project.secondhand.vo.Page;
import com.project.secondhand.vo.Temper;
@Mapper
public interface MemberMapper {
	//회원가입
	public int addMember(Member member);
	//로그인
	public LoginMember selectLoginMember(LoginMember loginMember);
	//사진 추가
	public void addMemberPic(MemberPic memberPic);
	//회원 주소 추가
	public void addMemberAddr(MemberAddr memberAddr);
	//회원 온도 추가
	public void addMemberTemper(Temper temper);
	//아이디(이메일) 찾기
	public String findMemberId(Member member);
	//비밀번호 찾기 
	public Member findMemberPw(Member member);
	//비밀번호 전송
	public int updateMemberPw(Member member);
	//회원 탈퇴
	public void removeMember(MemberInfo memberInfo);
	//회원 주소 삭제
	public int removeMemberAddr(MemberInfo memberInfo);
	//회원 사진 삭제
	public int removeMemberPic(MemberInfo memberInfo);
	//회원 정보 보기
	public MemberInfo selectMemberOne(LoginMember loginMember);
	//회원사진 삭제
	//public int removeMemberPic(MemberPic memberPic);
	//회원 정보 수정
	public int modifyMember(MemberInfo memberInfo);
	//회원 번호
	public int selectMemberNoByEmail(String email);
	// 회원 사진
	public String selectMemberPicOne(int memberNo);
	// 회원 리스트
	public List<MemberAndReportCnt> selectMemberList(Page page);
	// 회원 전체 행 수
	public int selectNoticeTotalRow();
	// 관리자 회원 상세보기
	public MemberInfo selectMemberOneByAdmin(int memberNo);
	// 관리자 회원이 올린 상품 리스트
	public List<ItemList> selectItemListByMemberNo(int memberNo);

}
 	