package com.project.secondhand.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.service.CategoryService;
import com.project.secondhand.service.ItemService;
import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemPic;
import com.project.secondhand.vo.ItemPicForm;
import com.project.secondhand.vo.ItemAndMemberAndMemberAddrAndItemPic;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private CategoryService categoryService;
	
	
	//아이템 삭제
	@GetMapping("removeItem")
	public String removeItem(@RequestParam(value="itemNo", required = false) int itemNo) {
		itemService.removeItem(itemNo);
		return "redirect:/itemList";
	}
	//아이템 상세보기
	@GetMapping("/itemInfo")
	public String selectItemInfo(ItemAndItemPic itemAndItemPic, Model model, @RequestParam(value="itemNo", required = false) int itemNo) {
		itemAndItemPic = itemService.selectItemInfo(itemAndItemPic);
		System.out.println(itemAndItemPic + "/itemAndItemPic/itemController");
		model.addAttribute("item", itemAndItemPic);
		System.out.println(itemAndItemPic + "/item/itemController");
		return "itemInfo";
		}
	//아이템 리스트
	@GetMapping("/itemList")
	public String selectItemList(Model model, String smallCity) {
		System.out.println(smallCity+"<--Ctrl.smallCity");
		ArrayList<ItemAndItemPic> list = itemService.selectItemListByAll();
		System.out.println(list + "/list/itemController");
		model.addAttribute("list", list);
		
		List<ItemAndMemberAndMemberAddrAndItemPic> maipList = itemService.searchItemByAddr(smallCity);
		
		return "itemList";
	}
	//아이템 추가하기
	@GetMapping("/addItem")
	public String addItem(Model model) {
		List<Category> categoryList = categoryService.getCategoryList("아이템");
		model.addAttribute("categoryList", categoryList);
		return "addItem";
	}
	@PostMapping("/addItem")
	public String addItem(ItemAndItemPic itemAndItemPic) {
		System.out.println(itemAndItemPic + "/itemAndItemPic/itemController");
		itemService.insertItem(itemAndItemPic);
		return "redirect:/itemList";
	}

}
