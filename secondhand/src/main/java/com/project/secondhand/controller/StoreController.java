package com.project.secondhand.controller;

import java.util.ArrayList;

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
