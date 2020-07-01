package com.project.secondhand.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ItemPic;



@Mapper
public interface ItemPicMapper {
	public int insertItemPic(ItemPic itemPic);
}
