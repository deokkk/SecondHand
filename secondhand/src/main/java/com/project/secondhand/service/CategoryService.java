package com.project.secondhand.service;

import java.util.List;

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
	
}
