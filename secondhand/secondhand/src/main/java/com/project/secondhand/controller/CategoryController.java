package com.project.secondhand.controller;

import java.util.List;

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

	@GetMapping("/getCategoryListByType")
	@ResponseBody
	public List<Category> getCategoryList(@RequestParam(value="categoryType") String categoryType) {
		return categoryService.getCategoryList(categoryType);
	}
	
	@GetMapping("/categoryList")
	public String categoryList(HttpSession session, Model model) {
		model.addAttribute("categoryList", categoryService.getCategoryListAll());
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
