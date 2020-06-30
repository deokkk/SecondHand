package com.project.secondhand.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.vo.MemberPic;

public class MemberController {
	
	
	//회원가입 Form
	@GetMapping("/addMember")
	public String addMember(HttpSession session) { //로그인이 되어있으면 index로 돌아가기
		if(session.getAttribute("loginMember")!=null) {
			return "redirect/";
		}
		return "addMember";
	}
	
	
	}

