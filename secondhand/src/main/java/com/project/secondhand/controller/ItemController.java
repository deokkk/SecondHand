package com.project.secondhand.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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
import com.project.secondhand.vo.ItemAndMemberAndMemberAddrAndItemPic;
import com.project.secondhand.vo.ItemList;
import com.project.secondhand.vo.ItemPic;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private CategoryService categoryService;
	
	
	//아이템 삭제
	@GetMapping("/removeItem")
	public String removeItem(@RequestParam(value="itemNo", required = false) int itemNo) {
		itemService.removeItem(itemNo);
		return "redirect:/itemList";
	}
	//아이템 수정 form
		@GetMapping("/modifyItem")
		public String modifyItem(HttpSession session, @RequestParam("itemNo") int itemNo, Model model) {
			System.out.println(itemNo+"/Ctrl.modify.itemNo");
			
			itemService.getUpdateItem(itemNo);
			System.out.println(itemNo+"<--Ctrl.modify.itemNo///////");
			
			Map<String, Object> map = itemService.getUpdateItem(itemNo);
			System.out.println(map+"/Ctrl.modify.map");
			
			
			ItemPic itemPic = (ItemPic)map.get("itemPic");
			System.out.println(itemPic+"/Ctrl.modify.itemPic!!!!!!");
			Item item = (Item)map.get("item");
			System.out.println(item + " <== Controller item??????");
			model.addAttribute("item", item);
			model.addAttribute("itemPic", itemPic);
			System.out.println(model+"<--/Ctrl.modify.model");
			return "/modifyItem";
		}
		//아이템 수정 action
		@PostMapping("/modifyItem")
		public String modifyItem(ItemAndItemPic itemAndItemPic) {
			System.out.println(itemAndItemPic+"<--Ctrl.action.itemAndItemPic;;;;;;");
			int itemNo = itemAndItemPic.getItemNo();
			System.out.println(itemNo+"<--Ctrl.action.itemNo!!!");
			itemAndItemPic.setItemNo(itemNo);
			System.out.println(itemAndItemPic+"<--itemAndItemPic??????");
			
			itemService.updateItem(itemAndItemPic);
			itemService.getUpdateItem(itemNo);
			System.out.println(itemService+"<--itemService");
			return "redirect:/itemList";
		}
	//아이템 상세보기
	@GetMapping("/itemInfo")
	public String selectItemInfo(ItemList itemList, Model model, @RequestParam(value="itemNo", required = false) int itemNo) {
		itemList = itemService.selectItemInfo(itemList);
		//System.out.println(itemList + "/itemList/itemController");
		model.addAttribute("item", itemList);
		return "itemInfo";
		}
	//아이템 리스트
	@GetMapping("/itemList")
	public String selectItemList(Model model, String smallCity) {
		System.out.println(smallCity+"<--Ctrl.smallCity");
		List<Category> categoryList = categoryService.getCategoryList("아이템");
		ArrayList<ItemList> itemList = itemService.selectItemListByAll();
		//System.out.println(itemList + "/itemList/itemController");
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
	public String addItem(Model model) {
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
