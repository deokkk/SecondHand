package com.project.secondhand.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemList;

@Mapper
public interface ItemMapper {
		//카테고리를 기준으로 상품 리스트 가져오기ㅑ
		public List<ItemList> selectItemByCategory(String categoryName);
		//주소를 기준으로 상품 리스트 가져오기
		public List<ItemList> selectItemByAddr(String smallCity);
		//상품리스트
		public ArrayList<ItemList> selectItemListByAll();
		//상품 상세보기
		public ItemList selectItemInfo(ItemList itemList);
		//상품 추가하기
		public void insertItem(Item item);
		//상품 수정하기
		public int updateItem(ItemAndItemPic itemAndItemPic);
		//상품 삭제하기
		public int deleteItem(int itemNo);
		//수정을 위한 상품 받아오기	
		public Item selectMemberItemInfoUpdate(int itemNo);
		
}
