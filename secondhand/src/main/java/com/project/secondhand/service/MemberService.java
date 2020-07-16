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
import com.project.secondhand.vo.Temper;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private JavaMailSender javaMailSender;

	// 회원가입
	public int addMember(Member member) {
		return memberMapper.addMember(member);
	}

	// 로그인
	public LoginMember login(LoginMember loginMember) {
		return memberMapper.selectLoginMember(loginMember);
	}

	// 이메일 인증번호 보내기
	public String emailCheck(String memberEmail) {

		UUID uuid = UUID.randomUUID();
		String emailCheck = uuid.toString().substring(0, 8);

		SimpleMailMessage mm = new SimpleMailMessage();
		mm.setTo(memberEmail);
		System.out.println(memberEmail + "<-----------------------------memberEmail");
		mm.setFrom("odooda0918@gmail.com");
		mm.setSubject("[이메일 인증]");
		mm.setText("인증번호는" + emailCheck + "입니다");
		javaMailSender.send(mm);

		return emailCheck;
	}

	// 회원 사진 추가
	public void addMemberPic(MemberPicForm memberPicForm) {
		MultipartFile mf = memberPicForm.getMemberPicName();
		String originName = mf.getOriginalFilename();
		System.out.println(originName + "<---------------- StoreSerivce");
		int lastDot = originName.lastIndexOf(".");
		String extension = originName.substring(lastDot);

		String memberPicName = memberPicForm.getMemberNo() + extension;

		String path = "D:\\maven.1594716682238\\secondhand\\src\\main\\resources\\static\\upload\\";

		File file = new File(path + memberPicName);
		try {
			mf.transferTo(file); // 예외처리가 꼭 필요한 코드
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(); // 예외처리를 없앤다.
		}
		MemberPic memberPic = new MemberPic();
		memberPic.setMemberNo(memberPicForm.getMemberNo());
		memberPic.setMemberPicName(memberPicName);

		memberMapper.addMemberPic(memberPic);
	}

	// 회원 닉네임 확인
	public Member nickCheck(String nickName) {
		return null;

	}

	// 회원 주소 추가
	public void addMemberAddr(MemberAddr memberAddr, Temper temper) {
		memberMapper.addMemberAddr(memberAddr);
		memberMapper.addMemberTemper(temper);
	}

	
	 //회원삭제 
	public void removeMember(MemberInfo memberInfo) { //멤버 이미지 파일 삭제 String
		
		if(memberMapper.removeMemberAddr(memberInfo)==1) {
			if(memberMapper.removeMemberPic(memberInfo)==1)memberMapper.removeMember(memberInfo);
		}
		// return memberMapper.addMember(member);
	 
	 }
	// 비밀번호 찾기
	public int getMemberPw(Member member) {
		UUID uuid = UUID.randomUUID();
		String memberPw = uuid.toString().substring(0, 8);
		member.setMemberPw(memberPw);
		int row = memberMapper.updateMemberPw(member);
		if (row == 1) {
			System.out.println(memberPw + "<--update memberPw");
			// 메일로 랜덤 비밀번호 전송
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(member.getMemberEmail()); // 메일받는사람
			simpleMailMessage.setFrom("SECONDHANADMIN"); // 메일 보내는 사람
			simpleMailMessage.setSubject("SECONDHADN 비밀번호 찾기 메일입니다");
			simpleMailMessage.setText("변경 비밀번호:" + memberPw + "새비밀번호로 변경해주세요");
			javaMailSender.send(simpleMailMessage);
		}
		return row;
	}

	// 아이디 찾기
	public String findMemberId(Member member) {
		return memberMapper.findMemberId(member);
	}

	// 회원 정보 보기
	public MemberInfo selectMemberOne(LoginMember loginMember) {
		return memberMapper.selectMemberOne(loginMember);
	}
	
	//회원 정보 수정
		public void modifyMember(MemberInfo memberInfo, MultipartFile memberPicForm) {
			
			MultipartFile mf = memberPicForm;
			String originName = mf.getOriginalFilename();

			int lastDot = originName.lastIndexOf(".");
			String extension = originName.substring(lastDot);

			String memberPicName = memberInfo.getMemberNo() + extension;
			
			memberInfo.setMemberPicName(memberPicName);
			
			if(memberMapper.modifyMember(memberInfo) == 1) {
				
				String path = "C:\\spring eclipse\\spring work_space\\maven.1593564314857\\secondhand\\src\\main\\resources\\static\\upload\\";
				
				
				
				File file = new File(path + memberPicName);

			      if(file.exists() == true){

			      file.delete();

			   }
			    
				
				File file2 = new File(path + memberPicName);
				try {
					mf.transferTo(file2); // 예외처리가 꼭 필요한 코드
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(); // 예외처리를 없앤다.
				}
			}
		}
	
	// 회원 번호 가져오기
	public int getMemberNoByEmail(String memberEmail) {
	   return memberMapper.selectMemberNoByEmail(memberEmail);
	}
}
