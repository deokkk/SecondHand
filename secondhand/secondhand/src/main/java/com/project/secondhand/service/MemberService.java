package com.project.secondhand.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.mapper.MemberMapper;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
import com.project.secondhand.vo.MemberAddr;
import com.project.secondhand.vo.MemberInfo;
import com.project.secondhand.vo.MemberPic;
import com.project.secondhand.vo.MemberPicForm;
@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private JavaMailSender javaMailSender;

	//회원가입
	public int addMember(Member member) {
		return memberMapper.addMember(member);
	}
	//로그인
	public LoginMember login(LoginMember loginMember) {
		return memberMapper.selectLoginMember(loginMember);
	}
	//이메일 인증번호 보내기
	public String emailCheck(String memberEmail) {
		
		UUID uuid = UUID.randomUUID();
		String emailCheck = uuid.toString().substring(0,8);
		
		SimpleMailMessage mm = new SimpleMailMessage();
		mm.setTo(memberEmail);
		System.out.println(memberEmail+"<-----------------------------memberEmail");
		mm.setFrom("odooda0918@gmail.com");
		mm.setSubject("[이메일 인증]");
		mm.setText("인증번호는"+ emailCheck+"입니다");
		javaMailSender.send(mm);
		
		return emailCheck;
		}
	//회원 사진 추가
	public void addMemberPic(MemberPicForm memberPicForm) {
	    MultipartFile mf = memberPicForm.getMemberPicName();
	    String originName = mf.getOriginalFilename();
	    System.out.println(originName + "<---------------- StoreSerivce");
	    int lastDot = originName.lastIndexOf(".");
	    String extension = originName.substring(lastDot);
	      
	    String memberPicName = memberPicForm.getMemberNo()+extension;
	      
	    String path = "C:\\spring eclipse\\spring work_space\\maven.1593564314857\\secondhand\\src\\main\\resources\\static\\upload\\";
	      
	    File file = new File(path+memberPicName);
	    try {
	       mf.transferTo(file);   //예외처리가 꼭 필요한 코드
	    } catch (Exception e) {
	       e.printStackTrace();
	       throw new RuntimeException();    //예외처리를 없앤다.
	    } 
	    MemberPic memberPic = new MemberPic();
	    memberPic.setMemberNo(memberPicForm.getMemberNo());
	    memberPic.setMemberPicName(memberPicName);
	    
	    memberMapper.addMemberPic(memberPic);
	   }
	//회원 주소 추가
	public void addMemberAddr(MemberAddr memberAddr) {
		memberMapper.addMemberAddr(memberAddr);
	}
	
	//회원 닉네임 확인
	public Member nickCheck(String nickName) {
		return null;
		
	}
	 
	//회원 정보 보기
	public MemberInfo selectMemberOne(LoginMember loginMember) {
		return memberMapper.selectMemberOne(loginMember);
	}
}
