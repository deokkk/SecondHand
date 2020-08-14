package com.project.secondhand.controller;

import java.util.List;
import java.util.Map;

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
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		return "/addNotice";
	}
	
	//입력하기 action(운영자)
	@PostMapping("/addNotice")
	public String addNotice(HttpSession session, Notice notice) {
		System.out.println(notice.toString());
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		noticeService.addNotice(notice);
		// notice list로
		return "redirect:/noticeList";
	}
	
	
	// 공지사항 리스트
	@GetMapping("/noticeList")
	public String getNoticeList(Model model, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		//model.addAttribute("noticeList", noticeService.getNoticeList());
		Map<String, Object> map = noticeService.getNoticeList(currentPage); 
		model.addAttribute("noticeList", map.get("noticeList"));
		model.addAttribute("page", map.get("page"));
		// noticeList 출력할 html
		return "noticeList";
	}

	// 공지사항 상세보기
	@GetMapping("/noticeDetail")
	public String getNotice(@RequestParam(value="noticeNo") int noticeNo, Model model) {
		model.addAttribute("notice", noticeService.getNoticeOne(noticeNo));
		// notice detail 페이지
		return "noticeDetail";
	}
	
	
	// 공지사항 수정 form(운영자)
	@GetMapping("/modifyNotice")
	public String modifyNotice(HttpSession session , @RequestParam(value="noticeNo") int noticeNo, Model model) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		model.addAttribute("notice", noticeService.getNoticeOne(noticeNo));
		// notice 수정폼 html
		return "modifyNotice";
	}
	
	// 공지사항 수정 action(운영자)
	@PostMapping("/modifyNotice")
	public String modifyNotice(HttpSession session, Notice notice) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		noticeService.modifyNotice(notice);
		// 수정한 게시물 페이지로
		return "redirect:/noticeDetail?noticeNo="+ notice.getNoticeNo();
	}
	
	// 공지사항 삭제(운영자)
	@GetMapping("/removeNotice")
	public String removeNotice(HttpSession session, @RequestParam(value="noticeNo") int noticeNo) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		noticeService.removeNotice(noticeNo);
		// notice list 페이지로
		return "redirect:/noticeList";
	}
	
}
