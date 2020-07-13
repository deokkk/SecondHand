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


import com.project.secondhand.service.CategoryService;
import com.project.secondhand.service.ItemService;
import com.project.secondhand.service.MemberService;
import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.ItemAndMemberAndMemberAddrAndItemPic;
import com.project.secondhand.vo.ItemList;
import com.project.secondhand.vo.LoginMember;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MemberService memberService;
	
	//업체홍보관련 카테고리 선택 템플릿
	@GetMapping("/categoryListByItem")
	public String categoryListByItem() {
		return "categoryListByItem";
	}
	//아이템 삭제
	@GetMapping("/removeItem")
	public String removeItem(HttpSession session, @RequestParam(value="itemNo", required = false) int itemNo) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		itemService.removeItem(itemNo);
		return "redirect:/itemList";
	}
	//아이템 상세보기
	@GetMapping("/itemInfo")
	public String selectItemInfo(ItemList itemList, Model model, @RequestParam(value="itemNo", required = false) int itemNo) {
		itemList = itemService.selectItemInfo(itemList);
		System.out.println(itemList + "/itemList/itemController");
		model.addAttribute("item", itemList);
		return "itemInfo";
		}
	//아이템 리스트
	@GetMapping("/itemList")
	public String selectItemList(HttpSession session, Model model, String smallCity, LoginMember loginMember) {
		List<Category> categoryList = categoryService.getCategoryList("아이템");
		ArrayList<ItemList> itemList = itemService.selectItemListByAll();
		System.out.println(itemList + "/itemList/itemController");
		model.addAttribute("list", itemList);
		model.addAttribute("categoryList", categoryList);
		return "itemList";
	}
	@PostMapping("/itemListByAddr")
	public String selectItemListByAddr(Model model, @RequestParam(value="smallCity", required = false) String smallCity) {
		List<ItemList> itemListByAddr = itemService.selectItemByAddr(smallCity);
		System.out.println(itemListByAddr + "/itemListByAddr/itemController");
		model.addAttribute("list", itemListByAddr);
		return "itemList";
	}
	@PostMapping("/itemListByCategory")
	public String selectItemListByCategory(Model model, @RequestParam(value="cateogryName", required = false) String categoryName) {
		List<ItemList> itemListByCategory = itemService.selectItemByCategory(categoryName);
		model.addAttribute("list", itemListByCategory);
		return "itemList";
	}
	//아이템 추가하기
	@GetMapping("/addItem")
	public String addItem(Model model, HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		List<Category> categoryList = categoryService.getCategoryList("아이템");
		model.addAttribute("categoryList", categoryList);
		return "addItem";
	}
	@PostMapping("/addItem")
	public String addItem(ItemAndMemberAndMemberAddrAndItemPic itemAndMemberAndMemberAddrAndItemPic) {
		System.out.println(itemAndMemberAndMemberAddrAndItemPic + "/itemAndMemberAndMemberAddrAndItemPic/itemController");
		itemService.insertItem(itemAndMemberAndMemberAddrAndItemPic);
		return "redirect:/itemList";
	}

}
