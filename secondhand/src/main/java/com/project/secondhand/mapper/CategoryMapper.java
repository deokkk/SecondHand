package com.project.secondhand.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Category;

@Mapper
public interface CategoryMapper {

	//카테고리 리스트
	public List<Category> selectCategoryList(String categoryType);
	
	// 전체 카테고리 리스트
	public List<Category> selectCategoryListAll();
	
	public int updateCategory(Map<String, String> map);
	
	public int deleteCategory(String categoryName);
	
	public int insertCategory(Category category);
}
