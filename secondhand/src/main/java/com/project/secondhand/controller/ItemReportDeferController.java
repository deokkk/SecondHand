package com.project.secondhand.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.secondhand.mapper.ItemReportDeferMapper;
import com.project.secondhand.service.AdminService;
import com.project.secondhand.service.CategoryService;
import com.project.secondhand.service.ItemReportDeferService;
import com.project.secondhand.vo.Admin;
import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.ItemReportDefer;

@Controller
public class ItemReportDeferController {
	@Autowired
	private ItemReportDeferService itemReportDeferService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private CategoryService categoryServcie;
	
	//상품 신고 리스트
	@GetMapping("/itemReportList")
	public String itemReportDeferList(HttpSession session, Model model) {
		//세션 : 로그인이 아닐때 활성화
		/*Admin loginAdmin = new Admin();
		loginAdmin = adminService.adminLogin(admin);
		if(loginAdmin==null) {//로그인 중이 아니면 인덱스로
			return "redirect:/adminLogin";
		}*/
		ArrayList<ItemReportDeferMapper> itemReport = itemReportDeferService.itemReportDeferList();
		System.out.println(itemReport+"<--itemReport.list");
		model.addAttribute("itemReport", itemReport);
		return "itemReportList";
	}
	//상품 신고 상세보기
	@GetMapping("/itemReportDeferInfo")
	public String itemReportDeferInfo(ItemReportDefer itemReportDefer,  @RequestParam(value="itemReportDeferNo")int itemReportDeferNo, Model model) {
		System.out.println(itemReportDeferNo + "/itemReportDeferNo/itemReportDeferController");
		itemReportDefer = itemReportDeferService.itemReportDeferInfo(itemReportDefer);
		System.out.println(itemReportDefer + "/itemReportDefer/itemReportDeferController");
		model.addAttribute("itemReportDefer", itemReportDefer);
		model.addAttribute("itemReportDeferNo", itemReportDeferNo);
		return "itemReportDeferInfo";
	}
	
	//상품신고 추가
	@GetMapping("/addItemReportDefer")
	public String addItemReportDefer(Model model, HttpSession session, @RequestParam(value="itemNo")int itemNo) {
		System.out.println(itemNo+"<--Ctrl.itemNo");
		List<Category> categoryList = categoryServcie.getCategoryList("아이템");
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("itemNo", itemNo);
		return "addItemReportDefer";
	}
	@PostMapping("/addItemReportDefer")
	public String addItemReportDefer(ItemReportDefer itemReportDefer, HttpSession session) {
		System.out.println(itemReportDefer+"<--Ctrl.itemReportDefer");
		itemReportDeferService.addItemReportDefer(itemReportDefer);
		return "redirect:/itemList";
		
	}
	

}
