package com.project.secondhand.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemPic;



@Mapper
public interface ItemPicMapper {
	public void insertItemPic(ItemPic itemPic);
	public int deleteItemPic(int itemNo);
}
