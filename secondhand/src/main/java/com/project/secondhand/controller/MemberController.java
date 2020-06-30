package com.project.secondhand.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.vo.MemberPic;

public class MemberController {

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

	// id 체크 Action
	@PostMapping("/memberIdCheck")
	public String memberIdCheck() {
		return "redirect:/";
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

	// 로그아웃
	@GetMapping("/logout")
		public String logout(HttpSession session) {
			if(session.getAttribute("loginMember")!=null) {
				return "redirect:/";
			}
			//세션종료
			session.invalidate();
			return "redirect:/";
		}
}
/*
 * //회원가입 Action
 * 
 * @PostMapping("/addMember") public String addMember(HttpSession session,
 * MemberPic memberPic) { if(session.getAttribute("loginMember")==null) {
 * MultipartFile mf = memberPic.getMemberPic();
 * if(memberPic.getMemberPic()!=null && !mf.getOriginalFilename().equals("")) {
 * if(!memberPic.getMemberPic().getContentType().equals("image/png")&&!memberPic
 * .getMemberPic().getContentType().equals("imge/jpeg")&&
 * !memberPic.getMemberPic().getContentType().equals("image/gif")) { return
 * "redirect:/addMember?imgMsg=n"; }}}}}
 */

