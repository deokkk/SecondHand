package com.project.secondhand.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.secondhand.mapper.CategoryMapper;
import com.project.secondhand.vo.Category;
import com.project.secondhand.vo.Page;

@Service
public class CategoryService {
	@Autowired
	private CategoryMapper categoryMapper;
	private int rowPerPage = 5;
	private int pagePerGroup = 5;
	//리스트가져오기
	public List<Category> getCategoryList(String categoryType){
		return categoryMapper.selectCategoryList(categoryType);
	}
	
	// 카테고리 리스트
	public Map<String, Object> getCategoryListAll(String categoryType, int currentPage) {
		List<Category> list = new ArrayList<Category>();
		Page page = new Page();
		page.setCurrentPage(currentPage);
		page.setRowPerPage(rowPerPage);
		int beginRow = (currentPage - 1) * rowPerPage;
		page.setBeginRow(beginRow);
		int totalRow = categoryMapper.selectCategoryTotalRow(categoryType);
		page.setTotalRow(totalRow);
		int lastPage = totalRow%rowPerPage!=0 ? totalRow/rowPerPage+1 : totalRow/rowPerPage;
		page.setLastPage(lastPage);
		int currentPageGroup = (currentPage-1)%pagePerGroup==0 ? currentPage : (currentPage-1)/pagePerGroup*pagePerGroup+1;
		page.setCurrentPageGroup(currentPageGroup);
		int lastPageGroup = lastPage%pagePerGroup!=0 ? lastPage/pagePerGroup+1 : lastPage/pagePerGroup;
		page.setLastPageGroup(lastPageGroup);
		page.setPagePerGroup(pagePerGroup);
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("categoryType", categoryType);
		inputMap.put("page", page);
		list = categoryMapper.selectCategoryListByPage(inputMap);
		
		Map<String, Object> map = new HashMap<>();
		map.put("categoryList", list);
		map.put("page", page);
		return map;
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
