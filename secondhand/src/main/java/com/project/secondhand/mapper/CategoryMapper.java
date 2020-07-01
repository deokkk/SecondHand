package com.project.secondhand.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Category;

@Mapper
public interface CategoryMapper {

	//카테고리 리스트
	public List<Category> selectCategoryList();
}
