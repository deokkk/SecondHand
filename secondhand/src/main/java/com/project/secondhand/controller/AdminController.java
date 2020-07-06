package com.project.secondhand.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.secondhand.service.AdminService;
import com.project.secondhand.vo.Admin;

@Controller
public class AdminController {
	@Autowired private AdminService adminService;
	
	@GetMapping("/adminLogin")
	public String adminLogin() {
		return "adminLogin";
	}
	
	@PostMapping("/adminLogin")
	public String adminLogin(HttpSession session, Admin admin) {
		Admin loginAdmin = adminService.adminLogin(admin);
		if(loginAdmin==null) {
			return "redirect:/adminLogin";
		}
		session.setAttribute("loginAdmin", loginAdmin.getAdminEmail());
		session.setAttribute("level", "admin");
		return "redirect:/index";
	}
}
