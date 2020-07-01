package com.project.secondhand.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.project.secondhand.service.ItemService;
import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemPic;
import com.project.secondhand.vo.ItemPicForm;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	//아이템 리스트
	@GetMapping("/itemList")
	public String selectItemList(Model model) {
		ArrayList<ItemAndItemPic> list = itemService.selectItemListByAll();
		System.out.println(list + "/list/itemController");
		model.addAttribute("list", list);
		return "itemList";
	}
	//아이템 추가하기
	@GetMapping("/addItem")
	public String addItem() {
		return "addItem";
	}
	@PostMapping("/addItem")
	public String addItem(Item item, ItemPic itemPic) {
		System.out.println(item + "/item/itemController");
		itemService.insertItem(item);
		return "redirect:/itemList";
	}
	@GetMapping("/addItemPic")
	public String addItemPic() {
		return "addItemPic";
	}
	@PostMapping("/addItemPic")
	public String addItemPic(ItemPicForm itemPicForm) {
		MultipartFile itemPicOne = itemPicForm.getItemPicNameOne();
		if(itemPicForm.getItemPicNameOne() != null && !itemPicOne.getOriginalFilename().equals("")) {
			//png, jpeg, gif 확장명을 가진 사진만 넣을 수 있음 
			if(!itemPicForm.getItemPicNameOne().getContentType().equals("image/png") ||
					!itemPicForm.getItemPicNameOne().getContentType().equals("image/jpeg") ||
					!itemPicForm.getItemPicNameOne().getContentType().equals("image/gif")) {
				return "redirect:/addItemPic?imgMsg=n";
			}
		int result = itemService.insertItemPic(itemPicForm);
		System.out.println(result + "/result");
		}
		return "redirect:/itemList";
	}

}
