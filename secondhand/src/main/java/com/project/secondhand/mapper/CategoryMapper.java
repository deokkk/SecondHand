package com.project.secondhand.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.Page;

@Mapper
public interface CategoryMapper {

	// 카테고리 타입별 리스트
	public List<Category> selectCategoryList(String categoryType);
	// 카테고리 타입별 행 수
	public int selectCategoryTotalRow(String categoryType);
	// 카테고리 리스트
	public List<Category> selectCategoryListByPage(Map<String, Object> map);
	// 전체 행 수
	public int selectCategoryAllTotalRow();
	// 카테고리 수정
	public int updateCategory(Map<String, String> map);
	// 카테고리 삭제
	public int deleteCategory(String categoryName);
	// 카테고리 입력
	public int insertCategory(Category category);
}
