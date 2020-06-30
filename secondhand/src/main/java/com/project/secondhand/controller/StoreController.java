package com.project.secondhand.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.secondhand.service.StoreService;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;

@Controller
public class StoreController {
	@Autowired
	private StoreService storeService;
	

	
	//업체가입 Form
	@GetMapping("/addStore")
	public String addStore(HttpSession session) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		return "addStore";
	}
	//업체가입 Action
	@PostMapping("/addStore")
	public String addStore() {
		
		return "redirect:/";
	}
	//업체 id Check Action
	@PostMapping("/storeIdCheck")
	public String storeIdCheck() {
		return "redirect:/";
	}
	//업체 email체크 (인증) Action
	@PostMapping("/storeEmailCheck")
	public String storeEmailCheck() {
		return "redirect:/";
	}
	//로그인 Form
	@GetMapping("/login")
	public String login(HttpSession session) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect:/";
		}
		return "login";
	}
	//로그인 Action
	@PostMapping("/login")
	public String login() {
		return "redirect:/";
	}
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect:/";
		}
		//세션종료
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	//업체홍보 리스트
	@GetMapping("/StoreBoardList")
	public String selectStoreBoardList(Model model) {
	ArrayList<StoreBoardAndBoardPic> list = storeService.selectStoreBoardList();
	model.addAttribute("list", list);
		return "StoreBoardList";
	}
	//업체홍보 상세보기
	@GetMapping("/StoreBoardListInfo")
	public String selectStoreBoardInfo(int boardNo) {
		return "StoreBoardListInfo";
	}
	
	//업체홍보 추가하기 form
	@GetMapping("/addStoreBoard")
	public String addStoreBoard() {
		return "addStoreBoard";
	}
	//업체홍보 추가하기 action
	@PostMapping("/addStoreBoard")
	public String addStoreBoard(StoreBoard storeBoard) {
		storeService.addStoreBoard(storeBoard);
		return "redirect:/StoreBoardList";
		
	}
	//업체홍보 수정하기
	@GetMapping("/modifyStoreBoard")
	public String modifyStoreBoard(StoreBoard storeBoard) {
		return "/modifyStoreBoard";
	}
	@PostMapping("/modifyStoreBoard")
	public String modifyStoreBoard() {
		return "redirect:/StoreBoardListInfo";
	}
	
	//업체홍보 삭제하기
	@GetMapping("/removeStoreBoard")
	public String removeStoreBoard(int boardNo) {
		return "redirect:/StoreBoardList";
	}
}
