package com.project.secondhand.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.secondhand.service.MemberService;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
import com.project.secondhand.vo.MemberPicForm;
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	// email 체크
	@GetMapping("/memberIdCheck")
	public String memberIdCheck(HttpSession session) { // 로그인 되어있으면 index로 돌아가는 조건문
		if (session.getAttribute("loginMember") != null) {
			return "redirect/";
		}
		return "memberIdCheck/";
	}

	// 회원가입 Form
	@GetMapping("/addMember")
	public String addMember(HttpSession session) { // 로그인이 되어있으면 index로 돌아가기
		if (session.getAttribute("loginMember") != null) {
			return "redirect/";
		}
		return "addMember";
	}
	// 회원가입 Action
	@PostMapping("/addMember") 
	public String addMember(HttpSession session,Member member) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		if(memberService.addMember(member)==1) {
			int memberNo = Integer.valueOf(String.valueOf(member.getMemberNo()));
		System.out.println(memberNo+"<<-memberNo");
		return "redirect:/addMemberPic?memberNo="+memberNo;
		}
		return "redirect:/";
	}
//  회원 email 체크 Action
	@PostMapping("/memberEmailSame")
	public String memberEmailSame(@RequestParam ("memberEmailSame") String memberEmailSame) {
		return "redirect:/addMember";
	}
// 회원 email 보내기
	@PostMapping("/memberEmailSend")
	@ResponseBody
	public String memberEmailSend (@RequestParam("memberEmail") String memberEmail) {
		return memberService.emailCheck(memberEmail);
	}
	
// email 체크(인증) action
	@PostMapping("/emailCheck")
	public String emailCheck() {
		return "redirect:/";
	}

// 로그인 Form
	@GetMapping("/login")
	public String login(HttpSession session) {
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}
		return "login";
	}
// 로그인 Action
	@PostMapping("/login")
	public String login() {
		return "redirect:/";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//세션종료
		session.invalidate();
		return "redirect:/";
}

	
//멤버 로그인 Form
	@GetMapping("/loginMember")
	public String loginMember(HttpSession session) {
		if (session.getAttribute("loginMember") != null) {
			return "redirect:/";
		}
		return "loginMember";
	}
//멤버 로그인 Action
	@PostMapping("/loginMember")
	public String loginMember(Model model, HttpSession session, LoginMember  loginMember) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		//System.out.println(loginMember+"<-loginMember");
		LoginMember returnLoginMember = memberService.login(loginMember);
		//System.out.println(returnLoginMember+"<-returnLoginMember");
		if(returnLoginMember == null) {//로그인 실패시
			model.addAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "loginMember";
		}else { //로그인 성공
			session.setAttribute("loginMember",loginMember);
			return "redirect:/";
		}
	}

//회원 닉네임 중복체크
	
	
	
	
	
//회원 사진 Form
	@GetMapping("/addMemberPic")
	public String addStorePic(HttpSession session,@RequestParam("memberNo") int memberNo,Model model) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		model.addAttribute("memberNo", memberNo);
		System.out.println(memberNo+"<--------------------------------addMemberPic");
		return "addMemberPic";
	}
//회원사진 Action
	@PostMapping("/addMemberPic")
	public String addMemberPic(HttpSession session, MemberPicForm memberPicForm,@RequestParam("memberNo") int memberNo,Model model) {
		System.out.println(memberPicForm.getMemberNo()+"<--------------------------addMemberpicNo");
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		// 파일 .jpg .png .gif 만 업로드 가능
		if(memberPicForm.getMemberPicName() != null) {
			if(!memberPicForm.getMemberPicName().getContentType().equals("image/jpg") && !memberPicForm.getMemberPicName().getContentType().equals("image/png") && !memberPicForm.getMemberPicName().getContentType().equals("image/gif") && !memberPicForm.getMemberPicName().getContentType().equals("image/jpeg")) {
				return "redirect:/addMemberPic";
			}
		}
		model.addAttribute("memberNo", memberNo);
		memberService.addMemberPic(memberPicForm);
		
		return "redirect:/addMemberAddr?memberNo="+memberNo;
	}
//회원주소 Form
	@GetMapping("/addMemberAddr")
	public String addMemberAddr(HttpSession session,@RequestParam("memberNo") int memberNo, Model model) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		model.addAttribute("memberNo", memberNo);
		return "addMemberAddr";
		
	}
//회원주소 추가 Action
	@PostMapping("/addMemberAddr")
	public String addMemberAddr(HttpSession session,@RequestParam("memberNo") int memberNo,@RequestParam("memberAddr") String memberAddr) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		System.out.println(memberAddr+"<-----------------------------memberControll memberAddr");
		System.out.println(memberNo+"<-----------------------------memberControll memberNo");
		
		String date[] = memberAddr.split(" ");
		for(int i=0; i<memberAddr.length(); i++) {
			System.out.println(date[i]+"<------------------------------------ 시 구 동");
		}
		
		return "redirect/";
	}
	
	
	
}


 
