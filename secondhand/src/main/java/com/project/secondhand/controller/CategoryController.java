package com.project.secondhand.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.secondhand.service.CategoryService;
import com.project.secondhand.vo.Category;

@Controller
public class CategoryController {
	@Autowired private CategoryService categoryService;
	
	@PostMapping("/addCategory")
	@ResponseBody
	public int addCategory(Category category) {
		return categoryService.addCategory(category);
	}
	
	@PostMapping("/removeCategory")
	@ResponseBody
	public int romoveCategory(@RequestParam(value = "categoryName") String categoryName) {
		return categoryService.removeCategory(categoryName);
	}
	
	/*
	@GetMapping("/getCategoryListByType")
	@ResponseBody
	public Map<String, Object> getCategoryList(@RequestParam(value="categoryType") String categoryType, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) { 
		return categoryService.getCategoryList(categoryType, currentPage);
	}
	*/
	
	@GetMapping("/categoryList")
	public String categoryList(HttpSession session, Model model, @RequestParam(value= "categoryType", defaultValue = "") String categoryType, @RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		if(session.getAttribute("loginAdmin") == null) {
			return "redirect:/";
		}
		Map<String, Object> map = categoryService.getCategoryListAll(categoryType, currentPage);
		model.addAttribute("categoryList", map.get("categoryList"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("categoryType", categoryType);
		return "categoryList";
	}
	
	@PostMapping("/modifyCategory")
	@ResponseBody
	public int modifyCategory(@RequestParam(value="categoryName") String categoryName, @RequestParam(value="originName") String originName) {
		System.out.println(categoryName + "<--categoryName");
		System.out.println(originName + "<--originName");
		return categoryService.modifyCategory(categoryName, originName);
	}
}
