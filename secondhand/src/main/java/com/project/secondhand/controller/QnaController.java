package com.project.secondhand.controller;

import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.secondhand.service.CategoryService;
import com.project.secondhand.service.QnaService;
import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.Qna;

@Controller
public class QnaController {
	@Autowired private QnaService qnaService;
	@Autowired private CategoryService categoryService;
	
	//자주묻는 질문 입력하기 form(운영자)
	@GetMapping("/addQna")
	public String addQna(HttpSession session, Model model) {
		System.out.println("/addQna 요청하기");
//			관리자로그인
//		if(관리자가 아닐떄) {
//			return "redirect:"/"
//		}
		List<Category> categoryList = categoryService.getCategoryList("qna");
		System.out.println(categoryList + "<--------categoryList");
		model.addAttribute("categoryList", categoryList);
		return "addQna";
	}
	
	//자주묻는 질문입력하기 action(운영자)
	@PostMapping("/addQna")
	public String addQna(HttpSession session, Qna qna) {
//			관리자 로그인
//		if(관리자가 아닐떄) {
//			return "redirect:"/"
//		}
		qnaService.addQna(qna);
		return "redirect:/qnaList";
	}
	
	//자주 묻는 질문 리스트
	@GetMapping("/qnaList")
	public String getQnaList(HttpSession session, Model model, @RequestParam(value = "searchWord",required = false)String searchWord) {
//		관리자 로그인
//	if(관리자가 아닐떄) {
//		return "redirect:"/"
//	}
		if(searchWord==null) {
			searchWord="";
		}
		Map<String, Object> map = qnaService.getQnaList(searchWord);
	 	model.addAttribute("qnaList", map.get("qnaList"));
	 	model.addAttribute("categoryList", map.get("categoryList"));
	
		return "/qnaList";
	}
	//자주 묻는 질문 상세보기
	@GetMapping("/qnaDetail")
	public String getDetail(HttpSession session, Model model, @RequestParam(value="qnaTitle")String qnaTitle) {
//		관리자 로그인							
//	if(관리자가 아닐떄) {
//		return "redirect:"/"
//	}
		System.out.println(qnaTitle +"<-------------qnatitle qnaDetail");
		model.addAttribute("qna", qnaService.getQna(qnaTitle));
		return "qnaDetail";
	}
	//자주 묻는 질문 수정하기 form(운영자)
//	@GetMapping("/modifyQna")
//	public String modifyQna(HttpSession session, Model model, @RequestParam(value ="qnaTitle")String qnaTitle) {
////		관리자 로그인							
////	if(관리자가 아닐떄) {
////		return "redirect:"/"
////	}
//		List<Category> list = categoryService.getCategoryList("qna");	
//		model.addAttribute("qna", qnaService.getQna(qnaTitle));
//		model.addAttribute("categoryList", list);
//		return "modifyQna";
//	}
//	//자주 묻는 질문 수정하기 action(운영자)
//	@PostMapping("/modifyQna")
//	public String modifyQna(HttpSession session, Qna qna) {
////		관리자 로그인							
////	if(관리자가 아닐떄) {
////		return "redirect:"/"
////	}
//		System.out.println(qna.toString());
//		qnaService.modifyQna(qna);
//		return "redirect:/qnaDetail?qnaTitle="+qna.getQnaTitle();
//	}
	//자주 묻는 질문 삭제하기
}
