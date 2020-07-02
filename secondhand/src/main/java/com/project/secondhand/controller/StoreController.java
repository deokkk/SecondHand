package com.project.secondhand.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.secondhand.service.StoreService;
import com.project.secondhand.vo.Store;
import com.project.secondhand.vo.StoreBoard;
import com.project.secondhand.vo.StoreBoardAndBoardPic;
import com.project.secondhand.vo.StorePicForm;

@Controller
public class StoreController {
	@Autowired
	private StoreService storeService;
	@Autowired 
	private JavaMailSender javaMailSender;
	//회원가입 선택화면
	@GetMapping("/addMemberChose")
	public String addMemberChose(HttpSession session) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		return "addMemberChose";
	}
	
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
	public String addStore(HttpSession session,Store store) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		
		if(storeService.addStore(store)==1) {
			int storeNo = Integer.valueOf(String.valueOf(store.getStoreNo()));
			System.out.println(storeNo+"<--------------------------------generatedKey");
			return "redirect:/addStorePic?storeNo="+storeNo;
		}
			
		
		
		return "redirect:/";
	}
	//업체 사진 Form
	@GetMapping("/addStorePic")
	public String addStorePic(HttpSession session,@RequestParam("storeNo") int storeNo,Model model) {
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		model.addAttribute("storeNo", storeNo);
		System.out.println(storeNo+"<--------------------------------addStorePic");
		return "addStorePic";
	}
	//업체사진 Action
	@PostMapping("/addStorePic")
	public String addStorePic(HttpSession session, StorePicForm storePicForm) {
		System.out.println(storePicForm.getStroreNo()+"<--------------------------addstorepicNo");
		if(session.getAttribute("loginStore")!=null) {
			return "redirect/";
		}
		// 파일 .jpg .png .gif 만 업로드 가능
		if(storePicForm.getStorePicName() != null) {
			if(!storePicForm.getStorePicName().getContentType().equals("image/jpg") && !storePicForm.getStorePicName().getContentType().equals("image/png") && !storePicForm.getStorePicName().getContentType().equals("image/gif") && !storePicForm.getStorePicName().getContentType().equals("image/jpeg")) {
				return "redirect:/addStorePic";
			}
		}
		
		storeService.addStorePic(storePicForm);
		
		return "redirect:/";
	}
	//업체 id Check Action
	@PostMapping("/storeEmailSame")
	public String storeEmailSame(@RequestParam("storeEmailSame") String storeEmailSame,HttpSession session,Model model) {
		return "redirect:/addStore";
	}
	//업체 email 보내기
	@PostMapping("/storeEmailSend")
	@ResponseBody
	public String storeEmailSend(@RequestParam("storeEmailSend") String storeEmailSend) {
		return storeService.emailCheck(storeEmailSend);
		}
		
		//업체 email체크 (인증) Action
		@PostMapping("/storeEmailCheck")
		public String storeEmailCheck() {
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
		//storeService.addStoreBoard(storeBoard);
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
