package com.project.secondhand.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.secondhand.vo.Item;
import com.project.secondhand.vo.ItemAndItemPic;
import com.project.secondhand.vo.ItemAndMemberAndMemberAddrAndItemPic;

@Mapper
public interface ItemMapper {
		//상품리스트
		public ArrayList<ItemAndItemPic> selectItemListByAll();
		//상품 상세보기
		public ItemAndItemPic selectItemInfo(ItemAndItemPic itemAndItemPic);
		//상품 추가하기
		public void insertItem(Item item);
		//상품 수정하기
		public void updateItem(Item item);
		//상품 삭제하기
		public int deleteItem(int itemNo);
		//날짜별 상품 리스트 출력
		public List<ItemAndMemberAndMemberAddrAndItemPic> searchItemByAddr(String smallCity);
}
