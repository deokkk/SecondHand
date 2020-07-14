package com.project.secondhand.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		public String modifyItem(HttpSession session, ItemList itemList, @RequestParam("itemNo") int itemNo, Model model) {
			System.out.println(itemNo+"/Ctrl.modify.itemNo");
			
			itemList = itemService.selectItemInfo(itemList);
			//System.out.println(itemList+"<--/Ctrl.modify.itemList");
			model.addAttribute("item", itemList);
			model.addAttribute("itemNo", itemNo);
			//System.out.println(model+"<--/Ctrl.modify.model");
			return "/modifyItem";
		}
		//아이템 수정 action
		@PostMapping("/modifyItem")
		public String modifyItem(ItemAndItemPic itemAndItemPic) {
			System.out.println(itemAndItemPic.getItemPicNameOne()+"/getItemPicNameOne<--Ctrl.modify.itemAndItemPic??????????");
			System.out.println(itemAndItemPic.getItemPicNameTwo()+"/getItemPicName2<--Ctrl.modify.itemAndItemPic??????????");
			System.out.println(itemAndItemPic.getItemPicNameThree()+"/getItemPicNam3eOne<--Ctrl.modify.itemAndItemPic??????????");
			System.out.println(itemAndItemPic.getItemPicNameFour()+"/getItemPicNameO4ne<--Ctrl.modify.itemAndItemPic??????????");
			System.out.println(itemAndItemPic.getItemPicNameFive()+"/getItemPicNameOn5e<--Ctrl.modify.itemAndItemPic??????????");
			String path = "D:\\maven.1594186776148\\secondhand\\src\\main\\resources\\static\\upload\\";
			
			String itemPicNameOne = null;
			String itemPicNameTwo = null;
			String itemPicNameThree = null;
			String itemPicNameFour = null;
			String itemPicNameFive = null;
			//새로운 파일이 등록되었는지 확인
			if(!itemAndItemPic.getItemPicNameOne().isEmpty()){
				itemPicNameOne = itemAndItemPic.getItemPicNameOne().getOriginalFilename();
				System.out.println(itemPicNameOne+"<--Ctrl.modify.itemPicNameOne");
			       try {
			          new File(path).mkdirs();
			          itemAndItemPic.getItemPicNameOne().transferTo(new File(path+itemPicNameOne));
			          
			          System.out.println(itemAndItemPic+"<--Ctrl.modify.itemAndItemPic");
			       } catch (Exception e) {
			          e.printStackTrace();
			       	}
			      }else {
			    	  itemPicNameOne = itemAndItemPic.getItemPicNameOne().getOriginalFilename();
			      }
				System.out.println(itemPicNameOne+"<--itemPicNameOne");
			      if(!itemAndItemPic.getItemPicNameTwo().isEmpty()) {
			    	  itemPicNameTwo = itemAndItemPic.getItemPicNameTwo().getOriginalFilename(); 
				       try {
				          new File(path).mkdirs();
				          itemAndItemPic.getItemPicNameTwo().transferTo(new File(path+itemPicNameTwo));
				       } catch (Exception e) {
				          e.printStackTrace();
				       }
			      }else {
			    	  itemPicNameTwo = itemAndItemPic.getItemPicNameTwo().getOriginalFilename();
			      }
				       if(!itemAndItemPic.getItemPicNameThree().isEmpty()) {
				    	   itemPicNameThree = itemAndItemPic.getItemPicNameThree().getOriginalFilename(); 
					       try {
					          new File(path).mkdirs();
					          itemAndItemPic.getItemPicNameThree().transferTo(new File(path+itemPicNameThree));
					       } catch (Exception e) {
					          e.printStackTrace();
					       }
				       }else {
				    	   itemPicNameThree = itemAndItemPic.getItemPicNameThree().getOriginalFilename();
					      }
					       if(!itemAndItemPic.getItemPicNameFour().isEmpty()) {
					    	   itemPicNameFour = itemAndItemPic.getItemPicNameFour().getOriginalFilename(); 
						       try {
						          new File(path).mkdirs();
						          itemAndItemPic.getItemPicNameFour().transferTo(new File(path+itemPicNameFour));
						       } catch (Exception e) {
						          e.printStackTrace();
						       } 
						 }else {
							 itemPicNameFour = itemAndItemPic.getItemPicNameFour().getOriginalFilename();
					      }
						       if(!itemAndItemPic.getItemPicNameFive().isEmpty()) {
						    	   itemPicNameFive = itemAndItemPic.getItemPicNameFive().getOriginalFilename(); 
							       try {
							          new File(path).mkdirs();
							          itemAndItemPic.getItemPicNameFive().transferTo(new File(path+itemPicNameFive));
							       } catch (Exception e) {
							          e.printStackTrace();
							       }
							 }else {
								 itemPicNameFive = itemAndItemPic.getItemPicNameFive().getOriginalFilename();
						      }
			ItemPic itemPic = new ItemPic();
			itemPic.setItemNo(itemAndItemPic.getItemNo());
			itemPic.setItemPicNameOne(itemPicNameOne);
			itemPic.setItemPicNameTwo(itemPicNameTwo);
			itemPic.setItemPicNameThree(itemPicNameThree);
			itemPic.setItemPicNameFour(itemPicNameFour);
			itemPic.setItemPicNameFive(itemPicNameFive);
			System.out.println(itemPic+"<--itemPic");
			itemService.updateItem(itemAndItemPic, itemPic);
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
