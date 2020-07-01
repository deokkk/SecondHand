package com.project.secondhand.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.secondhand.service.ItemService;
import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemPic;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	//아이템 리스트
	@GetMapping("/itemList")
	public String selectItemList(Model model) {
		ArrayList<ItemAndItemPic> list = itemService.selectItemListByAll();
		model.addAttribute("list", list);
		return "itemList";
	}
	//아이템 추가하기
	@GetMapping("/addItem")
	public String addItem() {
		return "addItem";
	}
	@PostMapping("/addItem")
	public String addItem(Item item, ItemPic itemPic, Model model) {
		Map<String,Object> map = itemService.insertItem(item, itemPic);
		return "redirect:/itemList";
	}

}
