package com.project.secondhand.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.secondhand.service.MemberService;
import com.project.secondhand.vo.LoginMember;
import com.project.secondhand.vo.Member;
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
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		if(memberService.addMember(member)==1) {
			int memberNo = Integer.valueOf(String.valueOf(member.getMemberNo()));
		System.out.println(memberNo+"<<-memberNo");
		return "redirect:/addMemberPic?memberNo="+memberNo;
		}
		return "redirect:/";
	}
//	// id 체크 Action
//	@PostMapping("/memberIdCheck")
//	public String memberIdCheck() {
//		return "redirect:/";
//	}
//
//	// email 체크(인증) action
//	@PostMapping("/emailCheck")
//	public String emailCheck() {
//		return "redirect:/";
//	}
//
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
		System.out.println(loginMember+"<-loginMember");
		Member returnLoginMember = memberService.login(loginMember);
		System.out.println(returnLoginMember+"<-returnLoginMember");
		if(returnLoginMember == null) {//로그인 실패시
			model.addAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "login";
		}else { //로그인 성공
			session.setAttribute("loginMember",loginMember);
			return "redirect:/";
		}
	}


//
//	// 로그아웃
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		if (session.getAttribute("loginMember") != null) {
//			return "redirect:/";
//		}
//		// 세션종료
//		session.invalidate();
//		return "redirect:/";
//	}
}


 
