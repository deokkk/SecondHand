package com.project.secondhand.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;

@Mapper
public interface ItemMapper {
		//상품리스트
		public ArrayList<ItemAndItemPic> selectItemListByAll();
		//상품 상세보기
		public Item selectItemInfo(int itemNo);
		//상품 추가하기
		public void insertItem(Item item);
		//상품 수정하기
		public int updateItem(Item item);
		//상품 삭제하기
		public int deleteItem(int itemNo);
}
