package com.project.secondhand.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;


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
//	자주 묻는 질문 수정하기 form(운영자)
	@GetMapping("/modifyQna")
	public String modifyQna(HttpSession session, Model model, @RequestParam(value ="qnaTitle")String qnaTitle) {
//		관리자 로그인							
//	if(관리자가 아닐떄) {
//		return "redirect:"/"
//	}
		List<Category> list = categoryService.getCategoryList("qna");	
		model.addAttribute("qna", qnaService.getQna(qnaTitle));
		model.addAttribute("categoryList", list);
		return "modifyQna";
	}
	//자주 묻는 질문 수정하기 action(운영자)
	@PostMapping("/modifyQna")
	public String modifyQna(HttpSession session, Qna qna, @RequestParam(value="originTitle") String originTitle) {
//		관리자 로그인							
//	if(관리자가 아닐떄) {
//		return "redirect:"/"
//	}
		qnaService.modifyQna(qna, originTitle);
		
		String qnaTitle = "";
		try {
			qnaTitle = URLEncoder.encode(qna.getQnaTitle(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:/qnaDetail?qnaTitle="+ qnaTitle;
	}
	//자주 묻는 질문 삭제하기
	@GetMapping("/removeQna")
	public String removeQna(HttpSession session, @RequestParam(value ="qnaTitle", required = false)String qnaTitle) {
//		관리자 로그인							
//	if(관리자가 아닐떄) {
//		return "redirect:"/"
//	}
		qnaService.removeQna(qnaTitle);
		return "redirect:/qnaList";
	}  
	
	//메일 문의하기(Form)
	@GetMapping("/sendQna")
	public String sendQna(HttpSession session, Model model) {
//									
//	if(로그인이 안되어있을때) {
//		return "redirect:"/"
//	}
		List<Category> list = categoryService.getCategoryList("qna");
		model.addAttribute("categoryList", list);
		return "sendQna";
	}
	//메일 문의하기(Action)
	@PostMapping("/sendQna")
	public String sendQna(HttpSession session, @RequestParam(value = "sendQnaCategory")String sendQnaCategory, @RequestParam(value = "sendQnaContent")String sendQnaContent) {
//		
//if(로그인이 안되어있을때) {
//return "redirect:"/"
//}	
		System.out.println(sendQnaCategory + "<-------------sendQnaCategory");
		System.out.println(sendQnaContent + "<-------------sendQnaContent");
		return "redirect:/qnaList";
	}
}
