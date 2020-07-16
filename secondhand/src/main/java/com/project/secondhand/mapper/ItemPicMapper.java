package com.project.secondhand.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemPic;

@Mapper
public interface ItemPicMapper {
	//아이템 사진 불러오기
	public ItemPic selectItemPic(int itemNo);
	//아이템 사진 추가
	public void insertItemPic(ItemPic itemPic);
	//아이템 사진 삭제
	public int deleteItemPic(int itemNo);
	//아이템 사진 수정
	public void updateItemPic(ItemPic ItemPic);

}
