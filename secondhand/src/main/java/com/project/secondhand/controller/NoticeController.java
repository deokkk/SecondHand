package com.project.secondhand.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.secondhand.service.NoticeService;
import com.project.secondhand.vo.Notice;

@Controller
public class NoticeController {
	@Autowired private NoticeService noticeService;
	
	//입력하기 form(운영자)
	@GetMapping("/addNotice")
	public String addNotice(HttpSession session) {
		
			
//		if(관리자가 아닐때) {
//			return "redirect:/index";
//		}
		
		// notice 입력폼 html
		return "/addNotice";
	}
	
	//입력하기 action(운영자)
	@PostMapping("/addNotice")
	public String addNotice(HttpSession session, Notice notice) {
		System.out.println(notice.toString());
//		if(관리자가 아닐때) {
//			return "redirect:/index";
//		} 
		
		noticeService.addNotice(notice);
		// notice list로
		return "redirect:/noticeList";
	}
	
	
	// 공지사항 리스트
	@GetMapping("/noticeList")
	public String getNoticeList(Model model) {
		//model.addAttribute("noticeList", noticeService.getNoticeList());
		List<Notice> list = noticeService.getNoticeList();
		for(Notice n : list) System.out.println(n.toString()+"<-------------------");
		model.addAttribute("list", list);
		// noticeList 출력할 html
		return "noticeList";
	}

	// 공지사항 상세보기
	@GetMapping("/noticeDetail")
	public String getNotice(@RequestParam(value="noticeNo") int noticeNo, Model model) {
		System.out.println("----------------------------------");
		model.addAttribute("notice", noticeService.getNoticeOne(noticeNo));
		// notice detail 페이지
		return "noticeDetail";
	}
	
	/*
	// 공지사항 수정 form(운영자)
	@GetMapping("")
	public String modifyNotice(HttpSession session , @RequestParam(value="noticeNo") int noticeNo, Model model) {
		/*
		if(관리자가 아닐때) {
			return "redirect:/index";
		}
		
		model.addAttribute("notice", noticeService.getNoticeOne(noticeNo));
		// notice 수정폼 html
		return "";
	}
	
	// 공지사항 수정 action(운영자)
	@PostMapping("")
	public String modifyNotice(HttpSession session, Notice notice) {
		/*
		if(관리자가 아닐때) {
			return "redirect:/index";
		}
		
		noticeService.modifyNotice(notice);
		// 수정한 게시물 페이지로
		// ex) return "redirect:/상세보기주소?noticeNo=notice.getNoticeNo";
		return "";
	}
	
	// 공지사항 삭제(운영자)
	@GetMapping("")
	public String removeNotice(HttpSession session, @RequestParam(value="noticeNo") int noticeNo) {
		/*
		if(관리자가 아닐때) {
			return "redirect:/index";
		}
		
		noticeService.removeNotice(noticeNo);
		// notice list 페이지로
		return "";
	}
	*/
}
