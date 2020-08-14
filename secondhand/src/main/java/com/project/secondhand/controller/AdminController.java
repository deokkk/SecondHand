package com.project.secondhand.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.secondhand.service.AdminService;
import com.project.secondhand.service.CategoryService;
import com.project.secondhand.service.ItemService;
import com.project.secondhand.vo.Admin;
import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.ItemList;

@Controller
public class AdminController {
	@Autowired private AdminService adminService;
	@Autowired private ItemService itemService;
	@Autowired private CategoryService categoryService;
	
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
	
	@GetMapping("/top")
	public String test() {
		return "topmenuTest";
	}
	
	//아이템 리스트
	@GetMapping("/itemListTest")
	public String selectItemList(Model model, String smallCity) {
		System.out.println(smallCity+"<--Ctrl.smallCity");
		List<Category> categoryList = categoryService.getCategoryList("아이템");
		ArrayList<ItemList> itemList = itemService.selectItemListByAll();
		//System.out.println(itemList + "/itemList/itemController");
		for(ItemList i : itemList) System.out.println(i.toString());
		model.addAttribute("list", itemList);
		model.addAttribute("categoryList", categoryList);
		return "itemListTest";
	}
}
