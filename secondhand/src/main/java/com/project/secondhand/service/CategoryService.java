package com.project.secondhand.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.CategoryMapper;
import com.project.secondhand.vo.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;
	
	//리스트가져오기
	public List<Category> getCategoryList(String categoryType){
		return categoryMapper.selectCategoryList(categoryType);
	}
	
	// 전체 리스트
	public List<Category> getCategoryListAll() {
		return categoryMapper.selectCategoryListAll();
	}
	
	public int modifyCategory(String categoryName, String originName) {
		System.out.println(categoryName);
		System.out.println(originName);
		Map<String, String> map = new HashMap<>();
		map.put("categoryName", categoryName);
		map.put("originName", originName);
		return categoryMapper.updateCategory(map);
	}
	
	public int removeCategory(String categoryName) {
		return categoryMapper.deleteCategory(categoryName);
	}
	
	public int addCategory(Category category) {
		return categoryMapper.insertCategory(category);
	}
}
